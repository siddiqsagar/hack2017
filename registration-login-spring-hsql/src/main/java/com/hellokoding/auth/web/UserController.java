package com.hellokoding.auth.web;

import com.hellokoding.auth.dto.*;
import com.hellokoding.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    RestTemplate restTemplate = new RestTemplate();

    final static String LOGIN_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String REGISTER_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String TRANSACTION = "http://dashdriverapi.azurewebsites.net/transaction?id={id}";

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("userForm", new UserDetails());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDetails userForm, Model model) {

        RegisterResponse registerResponse = restTemplate.postForObject(REGISTER_URI, userForm, RegisterResponse.class);

        String returnView = "registration";
        if ("SUCCESS".equalsIgnoreCase(registerResponse.getStatus())) {
            if ("MERCHANT".equalsIgnoreCase(userForm.getType())) {
                returnView = "merchanthome";
            } else if ("CUSTOMER".equalsIgnoreCase(userForm.getType())) {
                returnView = "cushome";
            }
        }
        return returnView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {


        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginBean") LoginBean loginBean) {


        LoginResponse loginResponse = restTemplate.postForObject(LOGIN_URI, loginBean, LoginResponse.class);
        if ("CUSTOMER".equalsIgnoreCase(loginResponse.getType())) {
            return "cushome";
        } else if ("MERCHANT".equalsIgnoreCase(loginResponse.getType())) {
            return "merchanthome";
        } else {
            return "login";
        }

    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelAndView transaction(HttpServletRequest httpServletRequest, @RequestParam("id") String id) {


        List<TransactionResponse> transactionResponseList = restTemplate.getForObject(TRANSACTION, List.class, id);

        return new ModelAndView("transactions", "transactionResponseList", transactionResponseList);

    }

}
