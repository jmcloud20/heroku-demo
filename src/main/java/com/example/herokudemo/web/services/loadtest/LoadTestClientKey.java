package com.example.herokudemo.web.services.loadtest;

public enum LoadTestClientKey {
    CUST_OPT("CUST_optOut_optIn"),
    PROD_OFFER("prod_offer"),
    CUST_EMAIL("cust_update_email");

    private final String name;
    LoadTestClientKey(String name){
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
}
