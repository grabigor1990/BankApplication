package com.telran.bank.service.impl;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.repository.AccountRepository;
import com.telran.bank.service.exception.AccountNotFoundException;
import com.telran.bank.util.DtoCreator;
import com.telran.bank.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    private UUID accountId;
    private Account account;
    private AccountDTO accountDTO;

    @Test
    @DisplayName("Get all accounts should return a list of AccountDTOs")
    void testGetAllAccounts() {
        account = EntityCreator.getAccount1();
        accountDTO = DtoCreator.createDefaultAccountDto();
        List<Account> accounts = Arrays.asList(EntityCreator.getAccount1(), EntityCreator.getAccount2());

        when(accountRepository.findAll()).thenReturn(accounts);
        when(accountMapper.toDtoList(Collections.singletonList(account))).thenReturn(Collections.singletonList(accountDTO));

        List<AccountDTO> accountDTOs = accountService.getAllAccount(null, null, null);

        assertEquals(1, accountDTOs.size());
        assertEquals(accountDTO, accountDTOs.get(0));
    }

    @Test
    @DisplayName("Create account should save and return an AccountDTO")
    void testCreateAccount() {
        when(accountMapper.dtoToAccount(accountDTO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);
        when(accountMapper.accountToDto(account)).thenReturn(accountDTO);

        AccountDTO savedAccountDTO = accountService.createAccount(accountDTO);

        assertNotNull(savedAccountDTO);
        assertEquals(accountDTO, savedAccountDTO);
        verify(accountRepository).save(account);
    }

    @Test
    @DisplayName("Get account should return an AccountDTO for an existing account")
    void testGetAccount() {
        this.accountId = UUID.randomUUID();
        Account account = EntityCreator.getAccount1();
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountMapper.accountToDto(account)).thenReturn(accountDTO);

        AccountDTO foundAccountDTO = accountService.getAccount(accountId);

        assertNotNull(foundAccountDTO);
        assertEquals(accountDTO, foundAccountDTO);
    }

    @Test
    @DisplayName("Get account should throw an AccountNotFoundException for a non-existing account")
    void testGetAccountNotFound() {
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.getAccount(accountId));
    }

    @Test
    @DisplayName("Update account should update and return an Account")
    void testUpdateAccount() {
        AccountDTO updatedAccountDTO = DtoCreator.createDefaultAccountDto();
        Account updatedAccount = EntityCreator.getAccount1();

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountMapper.dtoToAccount(updatedAccountDTO)).thenReturn(updatedAccount);
        when(accountRepository.save(updatedAccount)).thenReturn(updatedAccount);

        Account savedAccount = accountService.updateAccount(accountId, updatedAccountDTO);

        assertNotNull(savedAccount);
        assertEquals(updatedAccount, savedAccount);

        verify(accountRepository).save(updatedAccount);
    }

    @Test
    @DisplayName("Update account should throw an AccountNotFoundException for a non-existing account")
    void testUpdateAccountNotFound() {
        UUID nonExistingAccountId = UUID.randomUUID();
        AccountDTO updatedAccountDTO = DtoCreator.createDefaultAccountDto();

        when(accountRepository.findById(nonExistingAccountId)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.updateAccount(nonExistingAccountId, updatedAccountDTO));
    }

    @Test
    @DisplayName("Delete account should delete an existing account")
    void testDeleteAccount() {
        doNothing().when(accountRepository).deleteById(accountId);

        accountService.deleteAccount(accountId);

        verify(accountRepository).deleteById(accountId);
    }
}