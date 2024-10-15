package com.bank.account.service;

import com.bank.account.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankAccountServiceTest {

    @Mock
    private ResourceLoader resourceLoader;

    @Mock
    private Resource resource;

    @InjectMocks
    private BankAccountService bankAccountService;

    private List<BankAccount> mockAccounts;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        // Create a mock list of BankAccount objects
        mockAccounts = Arrays.asList(
                new BankAccount("123", "Customer1", new BigDecimal(1000)),
                new BankAccount("124", "Customer2", new BigDecimal(1500))
        );

        // JSON representation of the mock accounts
        String mockJson = "[{\"uuid\":\"123\",\"customerUuid\":\"Customer1\",\"balance\":1000}," +
                "{\"uuid\":\"124\",\"customerUuid\":\"Customer2\",\"balance\":1500}]";

        // Use a real InputStream created from the mock JSON
        InputStream inputStream = new ByteArrayInputStream(mockJson.getBytes(StandardCharsets.UTF_8));

        // Mock the resource loading behavior
        when(resourceLoader.getResource("classpath:Accounts.json")).thenReturn(resource);
        when(resource.getInputStream()).thenReturn(inputStream);
    }

    @Test
    void testGetAccounts() throws IOException {
        List<BankAccount> accounts = bankAccountService.getAccounts();

        assertNotNull(accounts);
        assertEquals(2, accounts.size());
        assertEquals("123", accounts.get(0).getUuid());
        verify(resourceLoader, times(1)).getResource("classpath:Accounts.json");
    }

    @Test
    void testFindBankAccountByUuid() throws IOException {
        Optional<BankAccount> account = bankAccountService.findBankAccountByUuid("123");

        assertTrue(account.isPresent());
        assertEquals("Customer1", account.get().getCustomerUuid());
    }

    @Test
    void testFindBankAccountByUuid_NotFound() throws IOException {
        Optional<BankAccount> account = bankAccountService.findBankAccountByUuid("999");

        assertFalse(account.isPresent());
    }

    @Test
    void testFindBankAccountsByCustomerUuid() throws IOException {
        List<BankAccount> customerAccounts = bankAccountService.findBankAccountsByCustomerUuid("Customer1");

        assertEquals(1, customerAccounts.size());
        assertEquals("123", customerAccounts.get(0).getUuid());
    }

    @Test
    void testAddNewAccount() throws IOException {
        BankAccount newAccount = new BankAccount("125", "Customer3", new BigDecimal(2000));
        String uuid = bankAccountService.addNewAccount(newAccount);

        assertTrue(bankAccountService.accounts.contains(newAccount));
    }
}

