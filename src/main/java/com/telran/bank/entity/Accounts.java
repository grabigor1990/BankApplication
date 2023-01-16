package com.telran.bank.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Accounts {
    @CreatedDate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAccount() {
        return createdAccount;
    }

    public void setCreatedAccount(LocalDateTime createdAccount) {
        this.createdAccount = createdAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public BigDecimal getAmountOfMany() {
        return amountOfMany;
    }

    public void setAmountOfMany(BigDecimal amountOfMany) {
        this.amountOfMany = amountOfMany;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Accounts account = (Accounts) obj;
        return Objects.equals(id, account.id);
    }
    @Override

    @java.lang.Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", createdAccount=" + createdAccount +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Country='" + country + '\'' +
                ", City='" + city + '\'' +
                ", amountOfMany=" + amountOfMany +
                '}';
    }
}
