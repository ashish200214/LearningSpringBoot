package com.security.LearningSpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.LearningSpringSecurity.model.UserModel;
import com.security.LearningSpringSecurity.repo.UserRepository;

@RestController
public class RegisterationController {
	@Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository repository;
    @PostMapping("/register/user")
    public UserModel methodToGetTheData(@RequestBody UserModel model){
        model.setPassword(encoder.encode(model.getPassword()));
        return repository.save(model);
        
    }
}
