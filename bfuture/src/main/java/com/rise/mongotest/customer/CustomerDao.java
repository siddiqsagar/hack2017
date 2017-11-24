package com.rise.mongotest.customer;

import com.rise.registration.dto.RegistrationRequest;

import java.util.List;

public interface CustomerDao {

    String addUser(RegistrationRequest registrationRequest);

    Customer findUserByEmailAddress(String emailAddress);

    Customer findByUserId(String userId);

    List<Customer> findByType(String type);
}
