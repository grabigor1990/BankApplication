package com.telran.bank.mapper;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AccountMapperTest {

    @Mock
    private Account account;

    @Mock
    private AccountDTO accountDTO;

    private final AccountMapper accountMapper = new AccountMapperImpl();


    @BeforeEach
    void setUp() {
        account = EntityCreator.getAccount1();
        accountDTO = DtoCreator.createAccountDto1();
    }

    @Test
    void testAccountToDto() {
        assertEquals(accountDTO.getId(), account.getId().toString());
        assertEquals(accountDTO.getCreatedAccount(), account.getCreatedAccount().toString());
        assertEquals(accountDTO.getEmail(), account.getEmail());
        assertEquals(accountDTO.getFirstName(), account.getFirstName());
        assertEquals(accountDTO.getLastName(), account.getLastName());

    }

    @Test
    void testDtoToAccount() {
        assertEquals(account.getId().toString(), accountDTO.getId());
        assertEquals(account.getCreatedAccount().toString(), accountDTO.getCreatedAccount());
        assertEquals(accountDTO.getEmail(), account.getEmail());
        assertEquals(accountDTO.getFirstName(), account.getFirstName());
        assertEquals(accountDTO.getLastName(), account.getLastName());
    }

    @Test
    void testToDtoList() {
        Account account1 = EntityCreator.getAccount1();
        Account account2 = EntityCreator.getAccount2();

        List<Account> accountList1 = new ArrayList<>();

        accountList1.add(account1);
        accountList1.add(account2);

        List<AccountDTO> accountDTOList1 = accountMapper.toDtoList(accountList1);

        Assertions.assertEquals(2, accountDTOList1.size());
        Assertions.assertEquals(account1.getFirstName(), accountDTOList1.get(0).getFirstName());
        Assertions.assertEquals(account1.getLastName(), accountDTOList1.get(0).getLastName());
        Assertions.assertEquals(account1.getEmail(), accountDTOList1.get(0).getEmail());
        Assertions.assertEquals(account2.getFirstName(), accountDTOList1.get(1).getFirstName());
        Assertions.assertEquals(account2.getLastName(), accountDTOList1.get(1).getLastName());
        Assertions.assertEquals(account2.getEmail(), accountDTOList1.get(1).getEmail());
    }
}