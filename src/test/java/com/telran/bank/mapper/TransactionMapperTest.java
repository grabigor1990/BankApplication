package com.telran.bank.mapper;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionMapperTest {

    @Mock
    Transaction transaction;

    @Mock
    TransactionDTO transactionDTO;

    private final TransactionMapper mapper = new TransactionMapperImpl();

    @BeforeEach
    void setUp() {
        transaction = EntityCreator.getTransaction1();
        transactionDTO = DtoCreator.createTransactionDto1();
    }

    @Test
    void testTransactionToDto() {
        assertEquals(transaction.getId().toString(), transactionDTO.getId());
        assertEquals(transaction.getType().toString(), transactionDTO.getType());
        assertEquals(transaction.getAccountFrom(), transactionDTO.getAccountFrom());
        assertEquals(transaction.getAccountTo(), transactionDTO.getAccountTo());
        assertEquals(transaction.getAmount().toString(), transactionDTO.getAmount());
        assertEquals(transaction.getDateTime().toString(), transactionDTO.getDateTime());
    }

    @Test
    void testDtoToTransaction() {
        assertEquals(transactionDTO.getId(), transaction.getId().toString());
        assertEquals(transactionDTO.getType(), transaction.getType().toString());
        assertEquals(transactionDTO.getAccountFrom(), transaction.getAccountFrom());
        assertEquals(transactionDTO.getAccountTo(), transaction.getAccountTo());
        assertEquals(transactionDTO.getAmount(), transaction.getAmount().toString());
        assertEquals(transactionDTO.getDateTime(), transaction.getDateTime().toString());
    }

    @Test
    void testToDtoList() {
        Transaction t1 = EntityCreator.getTransaction1();
        Transaction t2 = EntityCreator.getTransaction2();

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        transactions.add(t2);

        List<TransactionDTO> dtos = mapper.toDtoList(transactions);

        assertEquals(2, dtos.size());

        TransactionDTO dto1 = dtos.get(0);
        assertNotNull(dto1);

        assertEquals(new BigDecimal("123400.0").toString(), dto1.getAmount());
        assertEquals(LocalDate.of(2023, 3, 3).toString(), dto1.getDateTime());

        TransactionDTO dto2 = dtos.get(1);
        assertNotNull(dto2);
        assertEquals(t2.getId().toString(), dto2.getId());
        assertEquals(new BigDecimal("100.0").toString(), dto2.getAmount());
        assertEquals(LocalDate.of(2023, 4, 4).toString(), dto2.getDateTime());
    }
}
