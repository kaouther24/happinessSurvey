package com.bank.account.controller;

import com.bank.account.service.BankAccountService;
        import com.bank.account.model.BankAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BankAccountController.class)
public class BankAccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BankAccountController bankAccountController;

    @MockBean
    private BankAccountService bankAccountService;
    private ObjectMapper objectMapper = new ObjectMapper();

    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bankAccountController).build();
        account1 = new BankAccount("123", "Customer1", new BigDecimal(1000));
        account2 = new BankAccount("124", "Customer2", new BigDecimal(1500));
    }

    @Test
    void testHealthCheck() throws Exception {
        mockMvc.perform(get("/bankAccount/healthCheck"))
                .andExpect(status().isOk())
                .andExpect(content().string("Application is healthy"));
    }

    @Test
    void testGetAccountByUuid() throws Exception {
        // Mocking the service response
        when(bankAccountService.findBankAccountByUuid("123")).thenReturn(Optional.of(account1));

        mockMvc.perform(get("/bankAccount/byIdAccount/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid").value("123"))
                .andExpect(jsonPath("$.customerUuid").value("Customer1"))
                .andExpect(jsonPath("$.balance").value(1000));
    }


    @Test
    public void testCreateNewAccount() throws Exception {
        // Arrange: Prepare input BankAccount and mock response UUID
        BankAccount newAccount = new BankAccount("cust1", new BigDecimal(1000));
        String mockUuid = "generated-uuid-1234";

        // Mock the accountService behavior
        when(bankAccountService.addNewAccount(any(BankAccount.class))).thenReturn(mockUuid);

        // Act: Perform a POST request with the BankAccount JSON
        mockMvc.perform(post("/bankAccount/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newAccount)))
                .andExpect(status().isOk())
                .andExpect(content().string(mockUuid));
    }
}
