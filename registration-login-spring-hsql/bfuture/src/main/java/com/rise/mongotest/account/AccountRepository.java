package com.rise.mongotest.account;

import com.rise.mongotest.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account save(Account account);

    Account findById(String Id);
}

