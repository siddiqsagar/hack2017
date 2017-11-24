package com.rise.mongotest.transaction;

import com.rise.payment.dto.PaymentRequest;

import java.util.List;

public interface TransactionDao {

    String addTransaction(PaymentRequest paymentRequest);

    List<Transaction> getTransactions(String userId);

    List<Transaction> getAllTransactions();
}
