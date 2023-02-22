package com.telran.bank.mapper;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class AccountMapperTest {

    @Mock
    private AccountMapper accountMapper;

    @Mock
    private Account account;

    @Mock
    private AccountDTO accountDTO;

    @BeforeEach
    void setUp() {
        account = EntityCreator.getAccount1();
        accountDTO = DtoCreator.createDefaultAccountDto();
    }

    @Test
    void testAccountToDto() {
        when(accountMapper.accountToDto(account)).thenReturn(accountDTO);

        AccountDTO result = accountMapper.accountToDto(account);

        assertEquals(result, accountDTO);
    }

    @Test
    void testDtoToAccount() {
        when(accountMapper.dtoToAccount(accountDTO)).thenReturn(account);

        Account result = accountMapper.dtoToAccount(accountDTO);

        assertEquals(result, account);
    }

    @Test
    void testToDtoList() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);

        List<AccountDTO> expected = new ArrayList<>();
        expected.add(accountDTO);

        when(accountMapper.toDtoList(accounts)).thenReturn(expected);

        List<AccountDTO> result = accountMapper.toDtoList(accounts);

        assertEquals(result, expected);
    }
}