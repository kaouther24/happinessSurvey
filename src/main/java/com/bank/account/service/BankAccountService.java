package com.bank.account.service;

import com.bank.account.model.BankAccount;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    private final ResourceLoader resourceLoader;
    private static List<BankAccount> accounts;

    public BankAccountService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    // Loads the accounts from the JSON file
    public List<BankAccount> getAccounts() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:Accounts.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<BankAccount>>() {
        });
    }

    public Optional<BankAccount> findBankAccountByUuid(String uuid) throws IOException {
        if (accounts == null) {
            accounts = getAccounts();
        }
        return accounts.stream().filter(bankAccount -> bankAccount.getUuid().equalsIgnoreCase(uuid)).findFirst();
    }

    public List<BankAccount> findBankAccountsByCustomerUuid(String uuid) throws IOException {
        if (accounts == null) {
            accounts = getAccounts();
        }
        List<BankAccount> result = accounts.stream().filter(bankAccount -> bankAccount.getCustomerUuid().equalsIgnoreCase(uuid)).toList();
        return result;
    }

    public List<BankAccount> addNewAccount(BankAccount newAccount) throws IOException {
        if (accounts == null) {
            accounts = getAccounts();
        }
        accounts.add(newAccount);
        return accounts;
    }
}
