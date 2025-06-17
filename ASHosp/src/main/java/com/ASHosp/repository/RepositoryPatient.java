package com.ASHosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHosp.entity.Patient;

@Repository
public interface RepositoryPatient extends JpaRepository<Patient,Integer>{

}
