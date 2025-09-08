package com.training.softbankrestapi.dao;


import com.training.softbankrestapi.model.Account;
import com.training.softbankrestapi.util.OracleDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AccountDAOImpl implements AccountDAO {
    Connection con = OracleDBConnection.getConnection();
    private static  final String GET_ALL_ACCOUNTS = "select * from accounts";
    private final static String UPDATE_ACCOUNT = "update Accounts set customer_name = ?, mobile_number = ?, balance = ? where account_number = ?";
    private final String DELETE_ACCOUNT = "delete from Accounts where ACCOUNT_NUMBER=?";
    private static  final String CREATE_ACCOUNT_QUERY = "insert into accounts values ( ?, ?, ?, ?)";
    private final String FETCH_ACCOUNT_BALANCE = "select BALANCE from Accounts where ACCOUNT_NUMBER=?";
    private final String UPDATE_ACCOUNT_BALANCE = "update Accounts set BALANCE=? where ACCOUNT_NUMBER=?";
    private static final String SELECT_QUERY = "SELECT account_number, customer_name, mobile_number, balance FROM accounts WHERE mobile_number = ?";


    private static Logger logger =
            Logger.getLogger(AccountDAOImpl.class.getName());




    @Override
    public List<Account> getAccount()  {
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(GET_ALL_ACCOUNTS);
            List<Account> accounts = new ArrayList<>();
            while(res.next()){
                Account account = new Account(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getDouble(4));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAccount(String mobileNumber) {
        List<Account> accounts = new ArrayList<>();

        PreparedStatement ps = null ;
        try
        {
            ps = con.prepareStatement(SELECT_QUERY);
            // Set mobile number parameter
            ps.setString(1, mobileNumber);

            // Execute query
             ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Account account = new Account(
                            rs.getInt("account_number"),
                            rs.getString("customer_name"),
                            rs.getString("mobile_number"),
                            rs.getDouble("balance")
                    );
                    accounts.add(account);
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }




        return accounts;
    }


    @Override
    public boolean createAccount(Account account){
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_ACCOUNT_QUERY);
            ps.setInt(1,account.getAccountNumber());
            ps.setString(2,account.getCustomerName());
            ps.setString(3,account.getMobileNumber());
            ps.setDouble(4,account.getBalance());

            System.out.println(ps.toString());
            logger.info("Account created at :"+account.getAccountNumber());
            int res = ps.executeUpdate(); //DML
            return res == 0 ? false: true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateAccount(Account account){
        try {
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1, account.getCustomerName());
            preparedStatement.setString(2, account.getMobileNumber());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setInt(4, account.getAccountNumber());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }


    @Override
    public boolean deleteAccount(int accountNumber) {
        try{
            if(!isAccountExists(accountNumber)) return false;
            PreparedStatement ps = con.prepareStatement(DELETE_ACCOUNT);
            ps.setInt(1, accountNumber);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println( e.getMessage());
            return false;
        }
    }


    private static  final String GET_ALL_ACCOUNTS_ACCOUNT_NUMBER = "select * from accounts where account_number = ?";


    @Override
    public Account getAccount(int accountNumber) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_ACCOUNTS_ACCOUNT_NUMBER);
            preparedStatement.setInt(1,accountNumber);

            ResultSet res = preparedStatement.executeQuery();

            res.next();
            Account account = new Account(
                    res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getDouble(4));
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isAccountExists(int accountNumber) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_ACCOUNTS_ACCOUNT_NUMBER);
            preparedStatement.setInt(1,accountNumber);
            ResultSet res = preparedStatement.executeQuery();
            logger.warning("Account exists :");

            return res.next() ? true:false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public double fetchAccountBalance(int accountNumber) {
        logger.info("Account Balance fetched created at :");

        try{
            PreparedStatement ps = con.prepareStatement(FETCH_ACCOUNT_BALANCE);
            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
            return 0;
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public boolean transfer(int fromAccountNumber, int toAccountNumber, double amount) {


        PreparedStatement ps = null;
        try {
            con.setAutoCommit(false);

            double sourceAccountBalance = fetchAccountBalance(fromAccountNumber);
            if (sourceAccountBalance < amount) {
                System.out.println("Insufficient balance of the sender. Please check with them");
                return false;
            }

            ps = con.prepareStatement(UPDATE_ACCOUNT_BALANCE);
            ps.setDouble(1, sourceAccountBalance - amount);
            ps.setInt(2, fromAccountNumber);
            int updatedRows1 = ps.executeUpdate();

            double destAccountBalance = fetchAccountBalance(toAccountNumber);

            ps.setDouble(1, destAccountBalance + amount);
            ps.setInt(2, toAccountNumber);
            int updatedRows2 = ps.executeUpdate();

            if (updatedRows1 == 1 && updatedRows2 == 1) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;
            }

        } catch (Exception e) {
            try { con.rollback(); } catch (SQLException ex) {System.out.println("SQLException: " + e.getMessage());}
            System.out.println("SQLException: " + e.getMessage());
            return false;
        } finally {
            try {
                con.setAutoCommit(true);
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
    }



}
