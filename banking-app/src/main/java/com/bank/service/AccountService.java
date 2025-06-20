package com.bank.service;

import java.util.List;

import com.bank.dto.AccountDto;

public interface AccountService {
    AccountDto getAccountById(Long id);
    AccountDto createAccount(AccountDto dto);
    AccountDto depostiMoney(Long id,Double amount);
    AccountDto withdrawMoney(Long id, Double amount);
    List<AccountDto> getAllAccount();
    String deleteAccountById(Long id);
}
