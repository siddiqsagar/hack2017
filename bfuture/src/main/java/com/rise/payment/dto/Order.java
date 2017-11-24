package com.rise.payment.dto;

public class Order {

    private int chargeAmountDollars;

    private User user;

    public int getChargeAmountDollars() {
        return chargeAmountDollars;
    }

    public void setChargeAmountDollars(int chargeAmountDollars) {
        this.chargeAmountDollars = chargeAmountDollars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
