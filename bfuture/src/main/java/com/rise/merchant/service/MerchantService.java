package com.rise.merchant.service;

import com.rise.merchant.dto.Merchant;

import java.util.List;

public interface MerchantService {

    List<Merchant> getAllMerchant(String type);
}
