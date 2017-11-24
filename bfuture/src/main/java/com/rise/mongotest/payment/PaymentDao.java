package com.rise.mongotest.payment;

import java.util.List;

public interface PaymentDao {

    String payment(Payment payment);

    List<Payment> getTransactions(String id);
}
