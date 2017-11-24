package com.rise.payment.service;

import com.rise.constant.Constant;
import com.rise.mongotest.transaction.TransactionDao;
import com.rise.payment.dto.Order;
import com.rise.payment.dto.PaymentRequest;
import com.rise.payment.dto.PaymentResponse;
import com.rise.payment.dto.User;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public PaymentResponse payment(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = new PaymentResponse();

        Order order = new Order();
        order.setChargeAmountDollars(Integer.parseInt(paymentRequest.getTotalAmount()));
        order.setUser(new User());

        if(chargeCreditCard(order)) {
            String id = transactionDao.addTransaction(paymentRequest);
            if(null != id && !"".equals(id)) {
                paymentResponse.setStatus(Constant.SUCCESS);
                paymentResponse.setMessage("Order placed successfully");
            } else {
                paymentResponse.setStatus(Constant.FAILURE);
                paymentResponse.setMessage("Some Error occurred while placing order. Please try again later");
            }
        } else {
            paymentResponse.setStatus(Constant.FAILURE);
            paymentResponse.setMessage("Some Error occurred while placing order. Please try again later");
        }

        return paymentResponse;
    }

    public String createCustomer(User user) {
        Stripe.apiKey = "sk_test_JuUfskNfrwSLNFwsBDrYu0Wy";
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("description",
                user.getFirstName() + " " + user.getLastName());
        customerParams.put("email", user.getEmail());

        String id = null;

        try {
            // Create customer
            Customer stripeCustomer = Customer.create(customerParams);
            id = stripeCustomer.getId();
            System.out.println(stripeCustomer);
        } catch (Exception e) {
            // Something else happened unrelated to Stripe
        }

        return id;
    }

    public boolean chargeCreditCard(Order order) {

        Stripe.apiKey = "sk_test_JuUfskNfrwSLNFwsBDrYu0Wy";//Vender Stripe api key

        // Stripe requires the charge amount to be in cents
        int chargeAmountCents = (int) order.getChargeAmountDollars() * 100;

        User user = order.getUser();

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", chargeAmountCents);
        //chargeParams.put("amount", 2000);
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "Monthly Charges");
        //chargeParams.put("customer", user.getStripeCustomerId());
        chargeParams.put("customer", "cus_BoKDI2yrfB1Snt");

        try {
            // Submit charge to credit card
            Charge charge = Charge.create(chargeParams);
            System.out.println(charge);
            return true;
        } catch (Exception e) {
            System.out.println("Error In payment");
            return false;
        }
    }
}
