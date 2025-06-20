package com.customer.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.restapi.Entity.Customer;
import com.customer.restapi.repo.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public void createUser(Customer customer) {
        repository.save(customer);
    }

    public List<Customer> getAllUser() {
        return repository.findAll();
    }

    
    public void updateUser(Integer id, Customer customer) {
        Optional<Customer> opt = repository.findById(id);
    
        if (opt.isPresent()) {
            Customer oldCustomer = opt.get();
            oldCustomer.setName(customer.getName());
            oldCustomer.setAge(customer.getAge());
            oldCustomer.setCity(customer.getCity());
            repository.save(oldCustomer); // Saves the updated details
        } else {
            throw new RuntimeException("User doesn't exist...");
        }
    }
    

    public void deleteUser(Integer id) {

        repository.delete(repository.findById(id).get());
    }


}
