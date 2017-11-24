package com.rise.mongotest;

import com.rise.mongotest.customer.Customer;
import com.rise.registration.dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String addCustomer(RegistrationRequest registrationRequest) {
        Customer customer = new Customer();
        customer.setFirstName(registrationRequest.getFirstName());
        customer.setLastName(registrationRequest.getLastName());
        customer.setEmailAddress(registrationRequest.getEmailAddress());
        customer.setPassword("password");
        customer.setType("customer");
        mongoTemplate.save(customer);

        return customer.getId();
    }

    public List<Customer> findAllCustomer() {
        List<Customer>  customerList = new ArrayList<>();
        customerList = mongoTemplate.findAll(Customer.class);
        return  customerList;
    }

}
