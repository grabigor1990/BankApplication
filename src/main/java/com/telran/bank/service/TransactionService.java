package com.telran.bank.service;

import com.telran.bank.entity.Transactions;
import com.telran.bank.repository.StubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private StubRepository stubRepository;

    public Transactions saveTransaction(Transactions transactions) {
        return null;
    }
}
