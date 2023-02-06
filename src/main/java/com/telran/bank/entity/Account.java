package com.telran.bank.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {

    @CreatedDate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false )
    private String email;

    @Column(name = "created_account", nullable = false)
    private LocalDateTime createdAccount = LocalDateTime.now();

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "amount_of_many", nullable = false)
    private BigDecimal amountOfMany;

    @ManyToMany(mappedBy = "account",cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Transaction> transaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id.equals(account.id) && email.equals(account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
