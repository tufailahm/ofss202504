package com.training.softbankrestapi.dao;


import com.training.softbankrestapi.model.Account;

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
    public List<Account> getAccount(String mobileNumber);

    public boolean isAccountExists( int accountNumber) ;

}
