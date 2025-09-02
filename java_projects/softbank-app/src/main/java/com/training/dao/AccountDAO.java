package com.training.dao;

import com.training.model.Account;

import java.sql.SQLException;
import java.util.List;

//design pattern
public interface AccountDAO {
    public boolean createAccount( Account account) ;
     public boolean updateAccount( Account account);
    public boolean deleteAccount( int accountNumber);
    public Account getAccount(int accountNumber) ;

    double fetchAccountBalance(int accountNumber);

    public boolean transfer(int fromAccountNumber, int toAccountNumber, double amount);
    public List<Account> getAccount();

    public boolean isAccountExists( int accountNumber) ;

}
