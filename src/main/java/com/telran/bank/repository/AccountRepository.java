package com.telran.bank.repository;

import com.telran.bank.entity.Account;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @NonNull
    void deleteById(UUID id);

    @Override
    @NonNull
    Account save(Account account);

    Optional<Object> findById(UUID id);
}