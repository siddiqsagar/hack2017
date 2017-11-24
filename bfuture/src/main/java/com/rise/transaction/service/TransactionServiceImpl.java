package com.rise.transaction.service;

import com.rise.mongotest.transaction.Transaction;
import com.rise.mongotest.transaction.TransactionDao;
import com.rise.transaction.dto.TransactionRequest;
import com.rise.transaction.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public List<TransactionResponse> transaction(TransactionRequest transactionRequest) {

        List<TransactionResponse> transactionResponseList = new ArrayList<>();

        List<Transaction> transactionList = transactionDao.getTransactions(transactionRequest.getUserId());

        transactionList.forEach(transaction -> {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setTransactionId(transaction.getId());
            transactionResponse.setUserId(transaction.getUserId());
            transactionResponse.setTotalAmount(transaction.getTotalAmount());
            transactionResponse.setDescription(transaction.getDescription());
            transactionResponse.setTransactionDate(transaction.getTransactionDate());
            transactionResponse.setTransactionTime(transaction.getTransactionTime());
            transactionResponse.setOrderItemList(transaction.getOrderItemList());
            transactionResponseList.add(transactionResponse);
        });

        return transactionResponseList;
    }

    @Override
    public List<TransactionResponse> findAllTransaction() {
        List<TransactionResponse> transactionResponseList = new ArrayList<>();

        List<Transaction> transactionList = transactionDao.getAllTransactions();

        transactionList.forEach(transaction -> {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setTransactionId(transaction.getId());
            transactionResponse.setUserId(transaction.getUserId());
            transactionResponse.setTotalAmount(transaction.getTotalAmount());
            transactionResponse.setDescription(transaction.getDescription());
            transactionResponse.setTransactionDate(transaction.getTransactionDate());
            transactionResponse.setTransactionTime(transaction.getTransactionTime());
            transactionResponse.setOrderItemList(transaction.getOrderItemList());
            transactionResponseList.add(transactionResponse);
        });

        return transactionResponseList;
    }
}
