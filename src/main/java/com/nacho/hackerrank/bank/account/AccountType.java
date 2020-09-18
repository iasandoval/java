package com.nacho.hackerrank.bank.account;

public abstract class AccountType implements BankAccount{

    private final String name;
    private final String currency;
    private final long units;

    public AccountType(String name, String currency, long units) {
        this.name = name;
        this.currency = currency;
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public AccountType getAccountType() {
        return this;
    }

    @Override
    public long getUnits() {
        return this.units;
    }

    @Override
    public String getCurrency() {
        return this.currency;
    }

}
