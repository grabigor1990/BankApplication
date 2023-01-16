package com.telran.bank.repository;

import com.telran.bank.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {
    Transactions saveTransaction(Transactions transactions);

}
