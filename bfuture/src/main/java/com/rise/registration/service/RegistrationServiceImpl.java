package com.rise.registration.service;

import com.rise.constant.Constant;
import com.rise.mongotest.customer.Customer;
import com.rise.mongotest.customer.CustomerDao;
import com.rise.registration.dto.RegistrationRequest;
import com.rise.registration.dto.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private CustomerDao customerDao;

    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        RegistrationResponse registrationResponse = new RegistrationResponse();

        Customer customer = customerDao.findUserByEmailAddress(registrationRequest.getEmailAddress());
        if(customer != null) {
            registrationResponse.setStatus(Constant.FAILURE);
            registrationResponse.setMessage("Email address already used. Please try with some different email address");
        } else {
            String id = customerDao.addUser(registrationRequest);
            if(null != id && !"".equals(id)) {
                registrationResponse.setStatus(Constant.SUCCESS);
                registrationResponse.setMessage("Registered Successfully");
            } else {
                registrationResponse.setStatus(Constant.FAILURE);
                registrationResponse.setMessage("Some Error occurred during registration. Please try again later");
            }
            registrationResponse.setUserId(id);
        }

        return  registrationResponse;
    }
}
