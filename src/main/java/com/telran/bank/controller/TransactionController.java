package com.telran.bank.controller;

import com.telran.bank.entity.Transactions;
import com.telran.bank.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionsService;

    public TransactionController(TransactionService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public List<Transactions> getAllTransactions() {
        return transactionsService.getAllTransactions();
    }

    @PostMapping
    public Transactions createTransaction(@RequestBody Transactions transaction) {
        return transactionsService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    public Transactions updateTransaction(@PathVariable Long id, @RequestBody Transactions transaction) {
        return transactionsService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionsService.deleteTransaction(id);
    }
}

