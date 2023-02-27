package com.telran.bank.service.impl;

import com.telran.bank.dto.AccountDTO;
import com.telran.bank.entity.Account;
import com.telran.bank.entity.Transaction;
import com.telran.bank.exception.AccountNotFoundException;
import com.telran.bank.mapper.AccountMapper;
import com.telran.bank.repository.AccountRepository;
import com.telran.bank.repository.TransactionRepository;
import com.telran.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final TransactionRepository transactionRepository;

    public AccountDTO createAccount(AccountDTO accountDto) {
        Account account = accountMapper.dtoToAccount(accountDto);
        account.setId(account.getId());
        account.setCreatedAccount(LocalDate.now());
        accountRepository.save(account);
        return accountMapper.accountToDto(account);
    }

    @Override
    public List<AccountDTO> getAllAccount(String date, String city) {
        if (date != null || city != null) {
            return accountMapper.toDtoList(accountRepository.findAllByDateOrCity(LocalDate.parse(date), city));
        }
        return accountMapper.toDtoList(accountRepository.findAll());
    }

    @Override
    public AccountDTO getAccount(UUID id) {
        var account = (Account) accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountMapper.accountToDto(account);
    }

    @Override
    public Account updateAccount(UUID id, AccountDTO accountDTO) {
        Account existingAccount = (Account) accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
        existingAccount.setEmail(accountDTO.getEmail());
        existingAccount.setFirstName(accountDTO.getFirstName());
        existingAccount.setLastName(accountDTO.getLastName());
        existingAccount.setCountry(accountDTO.getCountry());
        existingAccount.setCity(accountDTO.getCity());
        return accountRepository.save(existingAccount);
    }

    @Override
    public void transfer(Account from, Account to, BigDecimal amount) {
        from.setAmountOfMany(from.getAmountOfMany().subtract(amount));
        to.setAmountOfMany(to.getAmountOfMany().add(amount));
        accountRepository.save(from);
        accountRepository.save(to);
        Transaction transactionFrom = new Transaction();
        Transaction transactionTo = new Transaction();

        //transactionFrom.setAccount(from);
        from.getTransactions().add(transactionFrom);
        to.getTransactions().add(transactionTo);
        //transactionTo.setAccount(to);
        transactionRepository.save(transactionFrom);
        transactionRepository.save(transactionTo);

    }

    @Override
    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }
}