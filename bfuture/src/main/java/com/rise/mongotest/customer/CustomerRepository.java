package com.rise.mongotest.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByEmailAddress(String emailAddress);

    Customer save(Customer customer);

    Customer findById(String Id);

    List<Customer> findByType(String type);
}
