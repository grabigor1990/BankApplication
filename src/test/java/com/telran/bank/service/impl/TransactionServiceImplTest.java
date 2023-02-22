package com.telran.bank.service.impl;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.mapper.TransactionMapper;
import com.telran.bank.repository.TransactionRepository;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionMapper transactionMapper;

    @InjectMocks
    private TransactionServiceImpl transactionService;
    private Transaction transaction;
    private TransactionDTO transactionDTO;

    @BeforeEach
    public void setUp() {
        transaction = EntityCreator.getTransaction1();
        transactionDTO = DtoCreator.createDefaultTransactionDto();
    }

    @Test
    void testGetTransaction() {
        when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
        when(transactionMapper.transactionToDto(any(Transaction.class))).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.getTransaction(transaction.getId());

        assertNotNull(result);
        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getAmount(), result.getAmount());
        assertEquals(transactionDTO.getType(), result.getType());

        when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.empty());
        transactionService.getTransaction(transaction.getId());
    }

    @Test
    void testGetAllTransaction() {
        Transaction transaction1 = EntityCreator.getTransaction1();
        Transaction transaction2 = EntityCreator.getTransaction2();
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);

        TransactionDTO transactionDTO1 = DtoCreator.createDefaultTransactionDto();
        TransactionDTO transactionDTO2 = DtoCreator.createDefaultTransactionDto();
        List<TransactionDTO> transactionDTOs = Arrays.asList(transactionDTO1, transactionDTO2);

        when(transactionRepository.findAll()).thenReturn(transactions);
        when(transactionMapper.toDtoList(transactions)).thenReturn(transactionDTOs);

        List<TransactionDTO> result = transactionService.getAllTransaction(null, null, null);

        assertEquals(2, result.size());
        assertEquals(transactionDTO1, result.get(0));
        assertEquals(transactionDTO2, result.get(1));
    }

    @DisplayName("Testing Transaction creation")
    @Test
    void createTransaction() {
        when(transactionMapper.dtoToTransaction(transactionDTO)).thenReturn(transaction);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        when(transactionMapper.transactionToDto(transaction)).thenReturn(transactionDTO);

        TransactionDTO createdTransactionDTO = transactionService.createTransaction(transactionDTO);

        assertEquals(transactionDTO, createdTransactionDTO);
        verify(transactionMapper, times(1)).dtoToTransaction(transactionDTO);
        verify(transactionRepository, times(1)).save(transaction);
        verify(transactionMapper, times(1)).transactionToDto(transaction);
    }
}