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

    @Override

    Account save(Account account);

    Optional<Object> findById(UUID id);

    @Override
    List<Account>findAll();

    List<Account> findAllByDateOrCity(LocalDate parse, String city);
}