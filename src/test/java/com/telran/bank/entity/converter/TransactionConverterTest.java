
package com.telran.bank.entity.converter;

import com.telran.bank.entity.enums.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionConverterTest {

    private TransactionConverter transactionConverter;

    @BeforeEach
    public void setUp() {
        transactionConverter = new TransactionConverter();
    }

    @Test
    public void shouldReturnTransactionTypeNameWhenConvertToDatabaseColumn() {
        TransactionType transactionType = TransactionType.DEPOSIT;
        String expected = transactionType.name();
        String actual = transactionConverter.convertToDatabaseColumn(transactionType);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWhenConvertToDatabaseColumnAndTransactionTypeIsNull() {
        TransactionType transactionType = null;
        String expected = null;
        String actual = transactionConverter.convertToDatabaseColumn(transactionType);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTransactionTypeWhenConvertToEntityAttribute() {
        String attribute = "DEPOSIT";
        TransactionType expected = TransactionType.findByType(attribute);
        TransactionType actual = transactionConverter.convertToEntityAttribute(attribute);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullWhenConvertToEntityAttributeAndAttributeIsNull() {
        String attribute = null;
        TransactionType expected = null;
        TransactionType actual = transactionConverter.convertToEntityAttribute(attribute);
        Assertions.assertEquals(expected, actual);
    }
}
