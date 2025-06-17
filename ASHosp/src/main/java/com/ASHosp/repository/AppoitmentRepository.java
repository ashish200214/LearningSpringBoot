package com.ASHosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ASHosp.entity.Appointment;

public interface AppoitmentRepository extends JpaRepository<Appointment,Integer>{

}
