package com.ASHosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHosp.entity.Patient;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryPatient extends JpaRepository<Patient,Integer>{
    public Optional<List<Patient>>findAllByMobileNo(String mobileNo);
}
