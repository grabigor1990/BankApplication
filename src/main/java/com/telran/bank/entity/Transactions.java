package com.telran.bank.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionID;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String type;
    private String accoutFrom;
    private String accountTo;
    private BigDecimal amount;
    @ManyToMany
    private List<Transactions> transactionsList;

    public Transactions(Long id, LocalDateTime dateTime, String type, String accoutFrom, String accountTo, BigDecimal amount, List<Transactions> transactionsList) {
        this.transactionID = id;
        this.dateTime = dateTime;
        this.type = type;
        this.accoutFrom = accoutFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.transactionsList = transactionsList;
    }

    public Transactions(long l, String transaction1, int i) {

    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccoutFrom() {
        return accoutFrom;
    }

    public void setAccoutFrom(String accoutFrom) {
        this.accoutFrom = accoutFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @java.lang.Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transactions)) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(dateTime, that.dateTime) && Objects.equals(type, that.type) && Objects.equals(accoutFrom, that.accoutFrom) && Objects.equals(accountTo, that.accountTo) && Objects.equals(amount, that.amount) && Objects.equals(transactionsList, that.transactionsList);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(transactionID, dateTime, type, accoutFrom, accountTo, amount, transactionsList);
    }

    @java.lang.Override
    public String toString() {
        return "Transactions{" +
                "id=" + transactionID +
                ", dateTime=" + dateTime +
                ", type='" + type + '\'' +
                ", accoutFrom='" + accoutFrom + '\'' +
                ", accountTo='" + accountTo + '\'' +
                ", amount=" + amount +
                ", transactionsList=" + transactionsList +
                '}';
    }
}
