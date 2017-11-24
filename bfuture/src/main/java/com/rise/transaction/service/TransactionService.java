package com.rise.transaction.service;

import com.rise.transaction.dto.TransactionRequest;
import com.rise.transaction.dto.TransactionResponse;

import java.util.List;

public interface TransactionService {

    List<TransactionResponse> transaction(TransactionRequest transactionRequest);

    List<TransactionResponse> findAllTransaction();
}
