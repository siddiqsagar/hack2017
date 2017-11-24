package com.rise.payment.dto;

public class User {

    private String firstName;

    private String lastName;

    private String email;

    private Object stripeCustomerId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(Object stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
    }
}
