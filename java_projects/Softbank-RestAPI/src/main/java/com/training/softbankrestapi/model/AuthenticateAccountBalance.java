package com.training.softbankrestapi.model;

import java.sql.SQLException;

public abstract class AuthenticateAccountBalance {
    protected abstract void checkBalance(int accountNumber)  throws SQLException;
}
