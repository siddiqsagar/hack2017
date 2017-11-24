package com.rise.mongotest.account;

public interface AccountDao {

    void account(Account account);

    Account getAccountDetails(String id);
}
