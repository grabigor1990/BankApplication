
package com.telran.bank.repository;

import com.telran.bank.BankApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StubRepository implements JpaRepository<BankApplication> {
}
