package com.bank.service;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import com.bank.exception.ResourceNotFoundException;
import com.bank.mapper.AccountMapper;
import com.bank.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountImpl implements  AccountService{
    @Autowired
    AccountRepository repository;

    @Override
    public AccountDto createAccount(AccountDto dto) {
        Account saveAccount = AccountMapper.AccountDTOToAccount(dto);
        repository.save(saveAccount);
        return AccountMapper.AccountToAccountDTO(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account entity= repository.findById(id).
        orElseThrow(
            ()->new ResourceNotFoundException("Account with id : "+id+"doesn't exist..."));
            return AccountMapper.AccountToAccountDTO(entity);

        }

    @Override
    public AccountDto depostiMoney(Long id, Double amount) {
        Account account= repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Account doesn't exist with id : "+id));
         Double currentBalance=account.getBalance();
         currentBalance +=amount;
         account.setBalance(currentBalance);
         repository.save(account);
         return AccountMapper.AccountToAccountDTO(account);
    }
    @Override
    public AccountDto withdrawMoney(Long id, Double amount) {
        Account acc = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Account not found with Id : "+id));    
        if(acc.getBalance()<amount){
            throw new RuntimeException("Insufficient Balance...");
        }
        else{
            Double currentBal = acc.getBalance();
            currentBal-=amount;
            acc.setBalance(currentBal);
            repository.save(acc);
        }
        return AccountMapper.AccountToAccountDTO(acc);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        return repository.findAll()
        .stream()
        .map((account)->AccountMapper.AccountToAccountDTO(account)).collect(Collectors.toList());
    }

    @Override
    public String deleteAccountById(Long id) {
        Account acc= repository.findById(id).orElseThrow(()->new RuntimeException("Resources not found..."));
        repository.delete(acc);
        return "User with id "+acc.getId()+" is deleted successfully";
    }    

}
