
package com.telran.bank.repository;


import com.telran.bank.entity.Account;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    @Query(value = "SELECT * FROM accounts WHERE created_account <= :date AND city IN :city ORDER BY :sort", nativeQuery = true)
    List<Account> findAll(String date, List<String> city, String sort);


    Optional<Account> findById(UUID id);

    @NonNull
    void deleteById(UUID id);

    @Override
    @NonNull
    Account save(Account account);
}
