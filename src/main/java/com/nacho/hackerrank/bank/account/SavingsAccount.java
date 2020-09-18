package com.nacho.hackerrank.bank.account;

public class SavingsAccount extends AccountType {

    private static final String NAME = "Savings";

    public SavingsAccount(String currency, long units) {
        super(NAME, currency, units);
    }
}
