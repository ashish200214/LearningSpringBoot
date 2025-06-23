package com.asent.customerDetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asent.customerDetails.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer>{
    Optional<CustomerEntity> findByName(String name);
    Optional<CustomerEntity> findByWhatappNo(String whatappno);
}
