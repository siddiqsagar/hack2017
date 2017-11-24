package com.rise.mongotest.customer;

import com.rise.registration.dto.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addUser(RegistrationRequest registrationRequest) {
        String id = "";

        Customer customer = new Customer();
        customer.setFirstName(registrationRequest.getFirstName());
        customer.setLastName(registrationRequest.getLastName());
        customer.setEmailAddress(registrationRequest.getEmailAddress());
        customer.setMobile(registrationRequest.getMobile());
        customer.setPassword(registrationRequest.getPassword());
        customer.setType(registrationRequest.getType());
        customer.setShopName(registrationRequest.getShopName());
        customer.setCardNumber(registrationRequest.getCardNumber());
        customer.setCardExpiryDate(registrationRequest.getCardExpiryDate());
        customer.setStripPublicKey(registrationRequest.getStripPublicKey());

        Customer customer1 = customerRepository.save(customer);
        id = customer1.getId();
        return id;
    }

    @Override
    public Customer findUserByEmailAddress(String emailAddress) {
        Customer customer = customerRepository.findByEmailAddress(emailAddress);
        return customer;
    }

    @Override
    public Customer findByUserId(String userId) {
        Customer customer = customerRepository.findById(userId);
        return customer;
    }

    @Override
    public List<Customer> findByType(String type) {
        List<Customer> customerList = customerRepository.findByType(type);
        return customerList;
    }
}
