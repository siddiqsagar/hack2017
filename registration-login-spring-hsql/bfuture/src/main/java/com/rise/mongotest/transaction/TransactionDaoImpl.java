package com.rise.mongotest.transaction;

import com.rise.mongotest.customer.Customer;
import com.rise.mongotest.customer.CustomerRepository;
import com.rise.payment.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

@Service("transactionDao")
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addTransaction(PaymentRequest paymentRequest) {

        //For Customer
        Transaction transactionCustomer = new Transaction();
        transactionCustomer.setUserId(paymentRequest.getCustomerId());
        transactionCustomer.setDescription(paymentRequest.getDescription());
        transactionCustomer.setTotalAmount(paymentRequest.getTotalAmount());

        LocalDate date = LocalDate.now();
        transactionCustomer.setTransactionDate(date.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        StringJoiner stringJoinerTime = new StringJoiner(":");
        stringJoinerTime.add(Integer.toString(localDateTime.getHour()));
        stringJoinerTime.add(Integer.toString(localDateTime.getMinute()));
        stringJoinerTime.add(Integer.toString(localDateTime.getSecond()));

        transactionCustomer.setTransactionTime(stringJoinerTime.toString());

        transactionCustomer.setOrderItemList(paymentRequest.getOrderItemList());

        Transaction transactionResult = transactionRepository.save(transactionCustomer);

        //For Merchant
        //Get customer details
        Customer customer = customerRepository.findById(paymentRequest.getCustomerId());

        Transaction transactionMerchant = new Transaction();
        transactionMerchant.setUserId(paymentRequest.getMerchantId());
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add("From Customer -");
        stringJoiner.add(customer.getFirstName());
        stringJoiner.add(customer.getLastName());
        transactionMerchant.setDescription(stringJoiner.toString());
        transactionMerchant.setTotalAmount(paymentRequest.getTotalAmount());

        transactionMerchant.setTransactionDate(date.toString());

        transactionMerchant.setTransactionTime(stringJoinerTime.toString());

        transactionMerchant.setOrderItemList(paymentRequest.getOrderItemList());
        transactionRepository.save(transactionMerchant);

        return transactionResult.getId();
    }

    @Override
    public List<Transaction> getTransactions(String userId) {
        List<Transaction> transactionList = transactionRepository.findByUserId(userId);

        return transactionList;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();

        return transactionList;
    }
}
