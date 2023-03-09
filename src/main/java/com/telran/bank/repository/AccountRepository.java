package com.telran.bank.repository;

import com.telran.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    void deleteById(UUID id);

    Optional<Account> findById(UUID id);

    List<Account> findAllByCreatedAccount(LocalDate parse);

    List<Account> findAllByCity(String city);
}