package com.telran.bank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
@Data
public class TransactionDTO {
    String id;
    String type;
    String accountFrom;
    String accountTo;
    String amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    String dateTime;
}