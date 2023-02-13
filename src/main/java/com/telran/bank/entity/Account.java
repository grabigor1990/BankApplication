package com.telran.bank.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @GenericGenerator(name = "UUID", strategy = "com.telran.bank.generator.UuidTimeSequenceGenerator")
    @Id

    @Column(name = "id")
    private UUID id;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "created_account")
    private LocalDateTime createdAccount = LocalDateTime.now();

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private List<Transaction> transactions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return id.equals(account.id) && email.equals(account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
