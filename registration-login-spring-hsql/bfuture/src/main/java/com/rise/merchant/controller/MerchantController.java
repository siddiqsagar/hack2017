package com.rise.merchant.controller;

import com.rise.merchant.dto.Merchant;
import com.rise.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(method = RequestMethod.GET, value = "/merchants", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Merchant> getMerchants(HttpServletRequest httpServletRequest, @RequestParam("type") String type) {
        List<Merchant> merchantList = merchantService.getAllMerchant(type);

        return merchantList;
    }
}
