package com.nacho.hackerrank.bank.account;

public class CheckingAccount extends AccountType {

    private static final String NAME = "Checking";

    public CheckingAccount(String currency, long units) {
        super(NAME, currency, units);
    }
}
