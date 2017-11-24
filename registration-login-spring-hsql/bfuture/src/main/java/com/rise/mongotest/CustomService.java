package com.rise.mongotest;

import com.rise.mongotest.customer.Customer;
import com.rise.registration.dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomService {

    @Autowired
    private CustomRepository customRepository;

    public String addCustomer(RegistrationRequest registrationRequest) {
        String id = customRepository.addCustomer(registrationRequest);
        return id;
    }

    public List<Customer> findAllCustomer() {
        List<Customer> customerList = customRepository.findAllCustomer();

        return customerList;
    }
}
