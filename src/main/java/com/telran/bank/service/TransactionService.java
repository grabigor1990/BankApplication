package com.telran.bank.service;

import com.telran.bank.entity.Transactions;
import com.telran.bank.exception.TransactionNotFoundException;
import com.telran.bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionsRepository;

    public TransactionService(TransactionRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    public Transactions createTransaction(Transactions transaction) {
        return transactionsRepository.save(transaction);
    }

    public Transactions updateTransaction(Long id, Transactions updatedTransaction) {
        Transactions transaction = transactionsRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + id));
        transaction.setType(updatedTransaction.getType());
        transaction.setAccoutFrom(updatedTransaction.getAccoutFrom());
        transaction.setAccountTo(updatedTransaction.getAccountTo());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setTransactionsList(updatedTransaction.getTransactionsList());
        return transactionsRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionsRepository.deleteById(id);
    }
}

