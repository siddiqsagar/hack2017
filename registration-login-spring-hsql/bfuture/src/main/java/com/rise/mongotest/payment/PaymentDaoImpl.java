package com.rise.mongotest.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("paymentDao")
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private PaymentRepository paymentRepository;

    public String payment(Payment payment) {
        String status = "Success";
        paymentRepository.save(payment);

        return status;
    }

    public List<Payment> getTransactions(String id) {
        List<Payment> paymentList = new ArrayList<>();

        paymentList = paymentRepository.findById(id);

        return paymentList;
    }
}
