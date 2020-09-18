package com.nacho.hackerrank.bank.account;

public class BrokerageAccount extends AccountType {

    private static final String NAME = "Brokerage";

    public BrokerageAccount(String currency, long units) {
        super(NAME, currency, units);
    }

}
