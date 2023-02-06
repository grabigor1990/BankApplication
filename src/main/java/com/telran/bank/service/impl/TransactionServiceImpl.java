package com.telran.bank.service;

import com.telran.bank.entity.Transaction;
import com.telran.bank.service.exception.TransactionNotFoundException;
import com.telran.bank.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionsRepository;

    public List<Transaction> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionsRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction transaction = transactionsRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + id));
        transaction.setType(updatedTransaction.getType());
        transaction.setAccoutFrom(updatedTransaction.getAccoutFrom());
        transaction.setAccountTo(updatedTransaction.getAccountTo());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setTransactionID(updatedTransaction.getTransactionsList());
        return transactionsRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionsRepository.deleteById(id);
    }
}

