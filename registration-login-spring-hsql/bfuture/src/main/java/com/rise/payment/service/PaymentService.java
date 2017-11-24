package com.rise.payment.service;

import com.rise.payment.dto.PaymentRequest;
import com.rise.payment.dto.PaymentResponse;

public interface PaymentService {

    PaymentResponse payment(PaymentRequest paymentRequest);
}
