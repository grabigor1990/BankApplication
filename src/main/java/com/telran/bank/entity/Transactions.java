package com.telran.bank.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionID;
    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();
    @Column(name = "type")
    private String type;
    @Column(name = "account_from")
    private String accoutFrom;
    @Column(name = "account_to")
    private String accountTo;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToMany
    private List<Transactions> transactionsList;

}
