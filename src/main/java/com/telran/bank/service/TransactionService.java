package com.telran.bank.service;

import com.telran.bank.dto.TransactionDTO;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    List<TransactionDTO> getAllTransaction(String date, String city);
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransaction(Long id);
}