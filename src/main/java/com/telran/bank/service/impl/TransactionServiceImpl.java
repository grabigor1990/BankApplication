package com.telran.bank.service.impl;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.mapper.TransactionMapper;
import com.telran.bank.repository.TransactionRepository;
import com.telran.bank.service.TransactionService;
import com.telran.bank.service.exception.TransactionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionsRepository;

    private final TransactionMapper transactionMapper;

    public TransactionDTO getTransaction(Long id) {
        Transaction transaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
        return transactionMapper.transactionToDto(transaction);
    }

    public List<TransactionDTO> getAllTransaction(String date, String city, String sort) {
        return transactionMapper.toDtoList(transactionsRepository.findAll(date, city, sort));
    }

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.dtoToTransaction(transactionDTO);
            transactionsRepository.save(transaction);
            return transactionMapper.transactionToDto(transaction);
    }
}

