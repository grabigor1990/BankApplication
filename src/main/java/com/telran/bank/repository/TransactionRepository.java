package com.telran.bank.repository;

import com.telran.bank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("ALL")
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    Optional<Object> findById(UUID id);
}