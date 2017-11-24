package com.rise.login.service;

import com.rise.constant.Constant;
import com.rise.login.dto.LoginRequest;
import com.rise.login.dto.LoginResponse;
import com.rise.mongotest.customer.Customer;
import com.rise.mongotest.customer.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        Customer customer = customerDao.findUserByEmailAddress(loginRequest.getUsername());
        if(customer != null) {
            loginResponse.setStatus(Constant.SUCCESS);
            loginResponse.setMessage("Login Successful");
            loginResponse.setUserId(customer.getId());
            //loginResponse.setType(customer.getType());
        } else {
            loginResponse.setStatus(Constant.FAILURE);
            loginResponse.setMessage("Your account does not present in our system. Please check your username");
        }

        return loginResponse;
    }
}
