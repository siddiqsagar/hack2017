package com.rise.mongotest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void account(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account getAccountDetails(String id) {
        Account account = accountRepository.findById(id);
        return account;
    }
}
