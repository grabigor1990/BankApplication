package com.telran.bank.service;

import com.telran.bank.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllTransaction(String date, String city);

    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransaction(Long id);
}