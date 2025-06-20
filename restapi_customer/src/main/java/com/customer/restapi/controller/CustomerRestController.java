package com.customer.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.customer.restapi.Entity.Customer;
import com.customer.restapi.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
public class CustomerRestController {
    
    @Autowired
    CustomerService service;
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody Customer customer){
        try{
            service.createUser(customer);
            return ResponseEntity.ok("User Created Succssfully");
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not created...");
        }
    }


    //Get all the customers.
    @GetMapping("/getAll")
    public List<Customer> getAllUser() {
        return service.getAllUser();
    }
    @PutMapping("/updateUser/{id}")
public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Customer customer) {
    try {
        service.updateUser(id, customer); 
        return ResponseEntity.ok("User updated successfully!"); // ✔ Correct return
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!"); // ✔ Handles errors
    }
}


    //delete customer.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        try{
            service.deleteUser(id);
            return ResponseEntity.ok("Deleted successfully");
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
