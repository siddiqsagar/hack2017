package com.rise.payment.controller;

import com.rise.payment.dto.PaymentRequest;
import com.rise.payment.dto.PaymentResponse;
import com.rise.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST, value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentResponse payment(HttpServletRequest httpServletRequest, @RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.payment(paymentRequest);
        return paymentResponse;
    }

}
