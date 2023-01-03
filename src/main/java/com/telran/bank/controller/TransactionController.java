package com.telran.bank.controller;

import com.telran.bank.entity.Transactions;
import com.telran.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class TransactionController {
    @Autowired
    private TransactionService transService;

    @Transactional
    @PostMapping("/transaction")
    public Transactions createTransaction(@RequestBody Transactions transactions){
        return transService.saveTransaction(transactions);
    }




}
