package com.telran.bank.service.impl;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.exception.TransactionNotFoundException;
import com.telran.bank.mapper.TransactionMapper;
import com.telran.bank.repository.TransactionRepository;
import com.telran.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionsRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDTO getTransaction(Long id) {
        Transaction transaction = transactionsRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
        return transactionMapper.transactionToDto(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransaction(String date, String city) {
        List<Transaction> transactions = transactionsRepository.findAll();
        var transactionsList = transactions.stream().toList();
        return transactionMapper.toDtoList(transactionsList);
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.dtoToTransaction(transactionDTO);
        transaction.setId(transaction.getId());
        transaction.setDateTime(transaction.getDateTime());
        transactionsRepository.save(transaction);
        return transactionMapper.transactionToDto(transaction);
    }
}