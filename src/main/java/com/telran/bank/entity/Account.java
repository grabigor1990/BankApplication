package com.telran.bank.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
@Builder
public class Account {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    @Column(name = "id")
    private UUID id;

    @CreatedDate
    @Column(name = "created_account")
    private LocalDate createdAccount = LocalDate.now();

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "amount_of_many")
    private BigDecimal amountOfMany;

    @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}