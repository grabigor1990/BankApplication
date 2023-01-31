
package com.telran.bank.repository;


import com.telran.bank.entity.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface AccountRepository extends JpaRepository<Accounts,Long> {

}
