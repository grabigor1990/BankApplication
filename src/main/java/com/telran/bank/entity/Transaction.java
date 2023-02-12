package com.telran.bank.entity;

import com.telran.bank.entity.enums.TransactionType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.telran.bank.generator.UuidTimeSequenceGenerator")


    @Column(name = "id")
    private UUID id;


    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "account_from")
    private String accountFrom;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private List<Account> accounts;
}
