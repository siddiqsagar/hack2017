package com.rise.payment.dto;

import com.rise.transaction.dto.OrderItem;

import java.util.List;

public class PaymentRequest {

    private String customerId;
    private String merchantId;
    private String totalAmount;
    private String description;
    private List<OrderItem> orderItemList;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "customerId='" + customerId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", description='" + description + '\'' +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
