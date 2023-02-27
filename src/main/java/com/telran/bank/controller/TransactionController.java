package com.telran.bank.controller;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.service.TransactionService;
import com.telran.bank.validation.Uuid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionsService.createTransaction(transactionDTO);
    }

    @GetMapping("/{id}")
    public TransactionDTO getTransaction(@Uuid @PathVariable Long id) {
        return transactionsService.getTransaction(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactions(@RequestParam(required = false) String date,
                                                   @RequestParam(required = false) String type) {
        return transactionsService.getAllTransaction(date, type);
    }
}