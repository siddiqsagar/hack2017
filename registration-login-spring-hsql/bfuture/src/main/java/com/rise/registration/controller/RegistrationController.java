package com.rise.registration.controller;

import com.rise.mongotest.CustomService;
import com.rise.mongotest.customer.Customer;
import com.rise.registration.dto.RegistrationRequest;
import com.rise.registration.dto.RegistrationResponse;
import com.rise.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CustomService customService;

    @RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistrationResponse register(HttpServletRequest httpServletRequest, @RequestBody RegistrationRequest registrationRequest) {
        RegistrationResponse registrationResponse = registrationService.register(registrationRequest);

        return registrationResponse;
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/registerCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistrationResponse registerCustomer(HttpServletRequest httpServletRequest, @RequestBody RegistrationRequest registrationRequest) {
        RegistrationResponse registrationResponse =  new RegistrationResponse();

        String id = customService.addCustomer(registrationRequest);
        registrationResponse.setUserId(id);

        return registrationResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> registerCustomer(HttpServletRequest httpServletRequest) {
        List<Customer> customerList = customService.findAllCustomer();
        return customerList;
    }*/
}
