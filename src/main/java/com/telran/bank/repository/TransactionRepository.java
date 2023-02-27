package com.telran.bank.repository;

import com.telran.bank.entity.Transaction;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("select t from Transaction t where t.id = ?1")
    @NonNull
    Optional<Transaction> findById(Long id);
}