package com.customer.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.restapi.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
