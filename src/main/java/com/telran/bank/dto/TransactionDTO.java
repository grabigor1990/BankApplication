package com.telran.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionDTO {
    public class TransactionsDTO {
        private Long transactionID;
        private LocalDateTime dateTime;
        private String type;
        private String accoutFrom;
        private String accountTo;
        private BigDecimal amount;
        private List<TransactionsDTO> transactionsList;
    }
}
