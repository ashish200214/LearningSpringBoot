package com.bank.controller;

import com.bank.dto.AccountDto;
import com.bank.service.AccountService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/accounts")
public class AccountController  {
    @Autowired
    private AccountService service;
    //add account rest api
    @PostMapping("/save")
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto dto){
        AccountDto dt2= service.createAccount(dto);
        return new ResponseEntity<>(dt2,HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getStudentById(@PathVariable Long id) {
        AccountDto dto = service.getAccountById(id);
        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/{id}/deposit")
    public ResponseEntity<String> depositMoney(@PathVariable Long id,@RequestBody Map<String,Double> deposit) {
        AccountDto dto= service.depostiMoney(id, deposit.get("amount"));
        return ResponseEntity.ok("Money Deposited Successfully and Current Balance is : "+dto.balance());
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> withdrawAmt){
        AccountDto dto= service.withdrawMoney(id,withdrawAmt.get("amount"));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("all")
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        List<AccountDto> list = service.getAllAccount();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        String s = service.deleteAccountById(id);
        return ResponseEntity.ok(s);
    }
    
    
}
