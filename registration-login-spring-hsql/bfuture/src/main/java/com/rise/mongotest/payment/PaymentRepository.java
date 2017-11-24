package com.rise.mongotest.payment;

import com.rise.mongotest.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment, String> {

    Payment save(Payment payment);

    List<Payment> findById(String id);
}
