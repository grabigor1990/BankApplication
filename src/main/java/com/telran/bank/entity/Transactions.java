package com.telran.bank.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String type;
    private String accoutFrom;
    private String accountTo;
    private BigDecimal amount;

}
