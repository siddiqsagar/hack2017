package com.rise.merchant.service;

import com.rise.merchant.dto.Merchant;
import com.rise.mongotest.customer.Customer;
import com.rise.mongotest.customer.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Merchant> getAllMerchant(String type) {
        List<Customer> customerList = customerDao.findByType(type);

        List<Merchant> merchantList = new ArrayList<>();
        customerList.forEach(customer -> {
            Merchant merchant = new Merchant();
            merchant.setMerchantId(customer.getId());
            merchant.setShopName(customer.getShopName());
            merchant.setMerchantName(customer.getFirstName().concat(" ").concat(customer.getLastName()));
            merchantList.add(merchant);
        });

        return merchantList;
    }
}
