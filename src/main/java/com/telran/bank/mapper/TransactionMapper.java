package com.telran.bank.mapper;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO transactionToDto(Transaction transaction);

    Transaction dtoToTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> toDtoList(List<Transaction> transactions);
}