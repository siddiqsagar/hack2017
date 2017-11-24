package com.rise.merchant.dto;

import java.util.List;

public class MerchantResponse {

    List<Merchant> merchantList;

    public List<Merchant> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<Merchant> merchantList) {
        this.merchantList = merchantList;
    }

    @Override
    public String toString() {
        return "MerchantResponse{" +
                "merchantList=" + merchantList +
                '}';
    }
}
