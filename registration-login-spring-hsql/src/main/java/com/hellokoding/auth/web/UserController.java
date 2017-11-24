package com.hellokoding.auth.web;

import com.hellokoding.auth.dto.LoginBean;
import com.hellokoding.auth.dto.LoginResponse;
import com.hellokoding.auth.dto.RegisterResponse;
import com.hellokoding.auth.dto.UserDetails;
import com.hellokoding.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    RestTemplate restTemplate = new RestTemplate();

    final static String LOGIN_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String REGISTER_URI = "http://dashdriverapi.azurewebsites.net/login";

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

}
