package com.telran.bank.dto;


import lombok.Value;

import java.util.UUID;

public class TransactionDTO {

    @Value
    public class TransactionsDTO {

        UUID id;
        String dateTime;

        String type;

        String accountFrom;

        String accountTo;

        String amount;
    }
}
