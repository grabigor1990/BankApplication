package com.telran.bank;

import com.telran.bank.controller.TransactionController;
import com.telran.bank.entity.Transactions;
import com.telran.bank.service.TransactionService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;
    @Mock
    private TransactionService transactionsService;
    private MockMvc mockMvc;

    @Before("")
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    public void testGetAllTransactions() throws Exception {
        Transactions transaction1 = new Transactions();
        Transactions transaction2 = new Transactions();
        List<Transactions> transactions = Arrays.asList(transaction1, transaction2);
        when(transactionsService.getAllTransactions()).thenReturn(transactions);

        mockMvc.perform(get("/transactions"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"transaction1\",\"amount\":100},{\"id\":2,\"name\":\"transaction2\",\"amount\":200}]"));

        verify(transactionsService, times(1)).getAllTransactions();
    }

    @Test
    public void testCreateTransaction() throws Exception {
        Transactions transaction = new Transactions();
        when(transactionsService.createTransaction(transaction)).thenReturn(transaction);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"transaction1\",\"amount\":100}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"transaction1\",\"amount\": 100}"));

        verify(transactionsService, times(1)).createTransaction(transaction);
    }
}
