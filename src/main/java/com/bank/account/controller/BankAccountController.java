package com.bank.account.controller;

import com.bank.account.model.BankAccount;
import com.bank.account.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/bankAccount")
public class BankAccountController {
    private BankAccountService accountService;

    public BankAccountController(BankAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Application is healthy");
    }

    @GetMapping("/byIdAccount/{accountUuid}")
    public Optional<BankAccount> getAccountByUuid(@PathVariable String accountUuid) throws IOException {

        return accountService.findBankAccountByUuid(accountUuid);
    }

    @GetMapping("/byCustomerId/{customerUuid}")
    public List<BankAccount> getAccountByCustomerUuid(@PathVariable String customerUuid) throws IOException {

        return accountService.findBankAccountsByCustomerUuid(customerUuid);
    }

    @PostMapping("/new")
    @ResponseBody
    public String createNewAccount(@RequestBody BankAccount bankAccount) throws IOException {

        BankAccount newAccount = new BankAccount(bankAccount.getCustomerUuid(), bankAccount.getBalance());
       return accountService.addNewAccount(newAccount);

    }
}
