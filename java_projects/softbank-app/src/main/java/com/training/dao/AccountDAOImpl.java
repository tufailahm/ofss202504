package com.training.dao;

import com.training.model.Account;
import com.training.util.OracleDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    Connection con = OracleDBConnection.getConnection();
    private static  final String GET_ALL_ACCOUNTS = "select * from accounts";
    @Override
    public List<Account> getAccount() throws SQLException {
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
    }

    private static  final String CREATE_ACCOUNT_QUERY = "insert into accounts values ( ?, ?, ?, ?)";

    @Override
    public boolean createAccount(Account account) throws SQLException {
        PreparedStatement ps = con.prepareStatement(CREATE_ACCOUNT_QUERY);
        ps.setInt(1,account.getAccountNumber());
        ps.setString(2,account.getCustomerName());
        ps.setString(3,account.getMobileNumber());
        ps.setDouble(4,account.getBalance());

        int res = ps.executeUpdate(); //DML
        return res == 0 ? false: true;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(int accountNumber) {
        return false;
    }


    private static  final String GET_ALL_ACCOUNTS_ACCOUNT_NUMBER = "select * from accounts where account_number = ?";


    @Override
    public Account getAccount(int accountNumber) throws SQLException {
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
    }

    @Override
    public boolean isAccountExists(int accountNumber) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_ACCOUNTS_ACCOUNT_NUMBER);
        preparedStatement.setInt(1,accountNumber);
        ResultSet res = preparedStatement.executeQuery();
        return res.next() ? true:false;
    }





    @Override
    public double transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        return 0;
    }




}
