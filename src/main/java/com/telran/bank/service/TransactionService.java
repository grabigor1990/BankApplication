package com.telran.bank.service;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllTransaction(String date, String city, String sort);

    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransaction(Long id);
}
