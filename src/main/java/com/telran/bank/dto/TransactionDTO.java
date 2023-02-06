package com.telran.bank.dto;


import lombok.Value;

public class TransactionDTO {

    @Value
    public class TransactionsDTO {

        String dateTime;

        String type;

        String accountFrom;

        String accountTo;

        String amount;
    }
}
