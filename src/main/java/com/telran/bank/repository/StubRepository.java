
package com.telran.bank.repository;


import com.telran.bank.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public  interface StubRepository extends JpaRepository<Accounts,Long> {
  @Query("")
  static double findBalanceByAccID(int accountID) {
        return 0;
    }

    static void saveBalanceByAccID(int accountId, double amount) {

    }

    void withdrawAmountByAccID(int accountID, double amount);

    void saveBalanceByAcctID(int destAccID, double amount);

    Accounts saveAcount(Accounts account);
}
