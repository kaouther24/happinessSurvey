package com.bank.account.model;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private String uuid;
    private BigDecimal balance;
    private String customerUuid;

    public BankAccount() {
    }

    public BankAccount(String customerUuid, BigDecimal balance) {
        this.balance = balance;
        this.customerUuid = customerUuid;
    }

    public BankAccount(String uuid, String customerUuid, BigDecimal balance) {
        this.uuid = uuid;
        this.balance = balance;
        this.customerUuid = customerUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal i) {
    }
}
