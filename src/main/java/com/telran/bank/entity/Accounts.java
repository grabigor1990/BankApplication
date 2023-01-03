package com.telran.bank.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Accounts {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @CreatedDate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private LocalDateTime createdAccount = LocalDateTime.now();
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private BigDecimal amountOfMany = BigDecimal.valueOf(0);


    public Accounts(Long id, String email, LocalDateTime createdAccount, String firstName, String lastName, String country, String city, BigDecimal amountOfMany) {
        this.id = id;
        this.email = email;
        this.createdAccount = createdAccount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.amountOfMany = amountOfMany;
    }

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
