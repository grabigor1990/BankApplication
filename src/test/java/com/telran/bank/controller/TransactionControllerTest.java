package com.telran.bank.controller;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.service.TransactionService;
import com.telran.bank.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    private static final Long TRANSACTION_ID = 1L;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @DisplayName("Create transaction successfully")
    @Test
    void testCreateTransactionSuccess() {
        TransactionDTO inputTransactionDTO = DtoCreator.createTransactionDto1();
        TransactionDTO expectedTransactionDTO = DtoCreator.createTransactionDto2();

        when(transactionService.createTransaction(inputTransactionDTO)).thenReturn(expectedTransactionDTO);

        TransactionDTO actualTransactionDTO = transactionController.createTransaction(inputTransactionDTO);
        assertEquals(expectedTransactionDTO, actualTransactionDTO);
    }

    @DisplayName("Get transaction by id successfully")
    @Test
    void testGetTransactionSuccess() {
        TransactionDTO expectedTransactionDTO = DtoCreator.createTransactionDto2();

        when(transactionService.getTransaction(TRANSACTION_ID)).thenReturn(expectedTransactionDTO);

        TransactionDTO actualTransactionDTO = transactionController.getTransaction(TRANSACTION_ID);
        assertEquals(expectedTransactionDTO, actualTransactionDTO);
    }

    @DisplayName("Get all transactions successfully")
    @Test
    void testGetAllTransactionsSuccess() {
        TransactionDTO expectedTransactionDTO1 = DtoCreator.createTransactionDto1();
        TransactionDTO expectedTransactionDTO2 = DtoCreator.createTransactionDto2();

        List<TransactionDTO> expectedTransactionDTOs = Arrays.asList(expectedTransactionDTO1, expectedTransactionDTO2);

        when(transactionService.getAllTransaction(null, null)).thenReturn(expectedTransactionDTOs);

        List<TransactionDTO> actualTransactionDTOs = transactionController.getAllTransactions(null, null);
        assertEquals(expectedTransactionDTOs, actualTransactionDTOs);
    }
}