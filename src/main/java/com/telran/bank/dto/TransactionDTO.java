package com.telran.bank.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

@Value
public class TransactionDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    String dateTime;

    String type;

    String accountFrom;

    String accountTo;

    String amount;
}

