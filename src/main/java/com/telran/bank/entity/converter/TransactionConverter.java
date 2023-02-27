package com.telran.bank.entity.converter;

import com.telran.bank.entity.enums.TransactionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TransactionConverter implements AttributeConverter<TransactionType, String> {
    @Override
    public String convertToDatabaseColumn(TransactionType transactionType) {
        if (transactionType != null)
            return transactionType.name();
        else
            return null;
    }

    @Override
    public TransactionType convertToEntityAttribute(String attribute) {
        if (attribute != null)
            return TransactionType.findByType(attribute);
        else
            return null;
    }
}