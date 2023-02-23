package com.telran.bank.mapper;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TransactionMapperTest {

    @Mock
    private TransactionMapper transactionMapper;

    @Mock
    private Transaction transaction1;
    private Transaction transaction2;

    @Mock
    private TransactionDTO transactionDTO;

    @BeforeEach
    void setUp() {
         transaction1 = EntityCreator.getTransaction1();
         transaction2 = EntityCreator.getTransaction2();
         transactionDTO = DtoCreator.createDefaultTransactionDto();
    }
    @Test
    void transactionToDto() {
        TransactionDTO transactionDto = transactionMapper.transactionToDto(transaction1);

        assertNotNull(transactionDto);
        assertEquals(transaction1.getId().toString(), transactionDto.getId());
        assertEquals(new BigDecimal("100.00").toString(), transactionDto.getAmount());
        assertEquals(LocalDateTime.of(2022, 1, 1,18,20,11).toString(), transactionDto.getDateTime());
    }

    @Test
    void dtoToTransaction() {
        Transaction transaction = transactionMapper.dtoToTransaction(transactionDTO);

        assertNotNull(transaction);
        assertEquals(transaction2.getId(), transaction.getId());
        assertEquals(new BigDecimal("200.00"), transaction.getAmount());
        assertEquals(LocalDateTime.of(2022, 2, 1,22,15,10), transaction.getDateTime());
    }

    @Test
    void toDtoList() {

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        List<TransactionDTO> dtos = transactionMapper.toDtoList(transactions);

        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        TransactionDTO dto1 = dtos.get(0);
        assertNotNull(dto1);
        assertEquals(transaction1.getId().toString(), dto1.getId());
        assertEquals(new BigDecimal("100.00").toString(), dto1.getAmount());
        assertEquals(LocalDateTime.of(2022, 1, 1,18,20,11).toString(), dto1.getDateTime());

        TransactionDTO dto2 = dtos.get(1);
        assertNotNull(dto2);
        assertEquals(transaction2.getId().toString(), dto2.getId());
        assertEquals(new BigDecimal("200.00").toString(), dto2.getAmount());
        assertEquals(LocalDateTime.of(2022, 2, 1,22,15,10).toString(), dto2.getDateTime());
    }
}