package com.rise.mongotest.transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    Transaction save(Transaction transaction);

    List<Transaction> findByUserId(String userId);

    List<Transaction> findAll();
}
