package com.training.dao;

import com.training.model.Account;

import java.sql.SQLException;
import java.util.List;

//design pattern
public interface AccountDAO {
    public boolean createAccount( Account account) throws SQLException;
     public boolean updateAccount( Account account);
    public boolean deleteAccount( int accountNumber);
    public Account getAccount(int accountNumber) throws SQLException;
    public double transfer( int fromAccountNumber,int toAccountNumber,double amount);
    public List<Account> getAccount() throws SQLException;

    public boolean isAccountExists( int accountNumber) throws SQLException;

}
