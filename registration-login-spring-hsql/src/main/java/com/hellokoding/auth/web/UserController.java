package com.hellokoding.auth.web;

import com.hellokoding.auth.dto.*;
import com.hellokoding.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("sessionObject")
public class UserController {
    @Autowired
    private UserService userService;



    RestTemplate restTemplate = new RestTemplate();

    final static String LOGIN_URI = "http://dashdriverapi.azurewebsites.net/login";
    final static String REGISTER_URI = "http://dashdriverapi.azurewebsites.net/register";
    final static String GET_MERCHANTS_URI = "http://dashdriverapi.azurewebsites.net/merchants";
    final static String TRANSACTION = "http://dashdriverapi.azurewebsites.net/transaction?id={id}";
    final static String MERCHANTS = "http://dashdriverapi.azurewebsites.net/merchants";
    final static String MENU = "http://dashdriverapi.azurewebsites.net/menu?id={id}";

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
                System.out.println("Register");
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
        String returnView = "login";
        LoginResponse loginResponse = restTemplate.postForObject(LOGIN_URI, loginBean, LoginResponse.class);
        System.out.println("login id" + loginResponse.toString());
       if ("SUCCESS".equalsIgnoreCase(loginResponse.getStatus())) {
           System.out.println("login ");
           returnView = "cushome";
           if ("CUSTOMER".equalsIgnoreCase(loginResponse.getType())) {
                returnView = "cushome";
               model.addAttribute("cusId", loginResponse.getUserId());
            } else if ("MERCHANT".equalsIgnoreCase(loginResponse.getType())) {
                returnView = "merchanthome";
               model.addAttribute("merchantId", loginResponse.getUserId());
            }
        }
        return returnView;
    }

    @RequestMapping(value = "/resolve", method = RequestMethod.POST)
    public String resolve(@ModelAttribute("resolveBean") ResolveBean resolveBean, Model model) {

        System.out.println("********************* ID"+resolveBean.getId());
        List<TransactionResponse> transactionResponseList = restTemplate.getForObject(TRANSACTION, List.class,resolveBean.getId());
        model.addAttribute("id" ,resolveBean.getId());

        System.out.println("transactionResponseList size - "+transactionResponseList.size());

        model.addAttribute("cusId" ,resolveBean.getId());
        model.addAttribute("transactionResponseList" ,transactionResponseList);

        List<Merchant> merchantList = restTemplate.getForObject(MERCHANTS, List.class);
        model.addAttribute("merchantList" ,merchantList);

        return resolveBean.getRequestView();
    }

    @RequestMapping(value = "/menus?merchantId={merchantId}", method = RequestMethod.GET)
    public ModelAndView getMenus(HttpServletRequest httpServletRequest, @RequestParam("merchantId") String merchantId, @RequestParam("cusId") String cusId) {
        httpServletRequest.setAttribute("cusId", cusId);
        httpServletRequest.setAttribute("merchantId", merchantId);

        List<Menu> menuList = restTemplate.getForObject(MENU, List.class, merchantId);
        return new ModelAndView("menus", "menuList", menuList);
    }

}
