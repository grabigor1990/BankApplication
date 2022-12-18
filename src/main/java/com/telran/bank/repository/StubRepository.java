
package com.telran.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StubRepository implements JpaRepository {
    public int findBalanceByAccID(int accountID) {
        return 0;
    }

    public void saveBalanceByAccID(int accountId, double amount) {
    }

    public void withdrawAmountByAccID(int accountID, double amount) {
    }
    public void saveBalanceByAcctID(int destAcctID, double amount) {
    }
}
