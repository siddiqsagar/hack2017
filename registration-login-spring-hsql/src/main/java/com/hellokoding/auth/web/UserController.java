package com.hellokoding.auth.web;

import com.hellokoding.auth.dto.*;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    RestTemplate restTemplate = new RestTemplate();

    final static String LOGIN_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String REGISTER_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String GET_MERCHANTS_URI = "http://dashdriverapi.azurewebsites.net/merchants";
    final static String TRANSACTION = "http://dashdriverapi.azurewebsites.net/transaction?id={id}";

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("userForm", new UserDetails());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDetails userForm, Model model) {

        RegisterResponse registerResponse = restTemplate.postForObject(REGISTER_URI, userForm, RegisterResponse.class);

        List<Merchant> listOfAvailableMerchants = (List<Merchant>) restTemplate.getForEntity(GET_MERCHANTS_URI, List.class);


        String returnView = "registration";
        if ("SUCCESS".equalsIgnoreCase(registerResponse.getStatus())) {
            if ("MERCHANT".equalsIgnoreCase(userForm.getType())) {
                model.addAttribute("cusId", registerResponse.getUserId());
                returnView = "merchanthome";
            } else if ("CUSTOMER".equalsIgnoreCase(userForm.getType())) {
                model.addAttribute("merchantId", registerResponse.getUserId());
                returnView = "cushome";
            }
        }
        return returnView;
    }

    @ModelAttribute("typeList")
    public List getTypeList() {

        List typeList = new ArrayList();
        typeList.add("Merchant");
        typeList.add("Customer");
        return typeList;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {


        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginBean") LoginBean loginBean, Model model) {
        String returnView = "cushome";
        LoginResponse loginResponse = restTemplate.postForObject(LOGIN_URI, loginBean, LoginResponse.class);
        System.out.println("login id" + loginResponse.getUserId());
       /* if ("SUCCESS".equalsIgnoreCase(loginResponse.getStatus())) {
            model.addAttribute("id", loginResponse.getId());
            if ("CUSTOMER".equalsIgnoreCase(loginResponse.getType())) {
                returnView = "cushome";
            } else if ("MERCHANT".equalsIgnoreCase(loginResponse.getType())) {

                returnView = "merchanthome";

            }
        }*/
        model.addAttribute("id", loginResponse.getUserId());
        return returnView;
    }

//   @RequestMapping(value = "/cushome", method = RequestMethod.GET)
//    public String cushome(Model model, String error, String logout) {
//
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "cushome";
//    }

    @RequestMapping(value = "/resolve", method = RequestMethod.POST)
    public String resolve(@ModelAttribute("resolveBean") ResolveBean resolveBean, Model model) {

        System.out.println("********************* ID"+resolveBean.getId());
        List<TransactionResponse> transactionResponseList = restTemplate.getForObject(TRANSACTION, List.class, resolveBean.getId());

        model.addAttribute("id" ,resolveBean.getId());
        model.addAttribute("transactionResponseList" ,transactionResponseList);
        return resolveBean.getRequestView();
    }

}
