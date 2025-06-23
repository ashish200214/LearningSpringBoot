package com.ASHosp.repository;

import com.ASHosp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ASHosp.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppoitmentRepository extends JpaRepository<Appointment,Integer>{
    @Query("SELECT a FROM Appointment a WHERE a.patient.mobileNo = :mobileNo")
    List<Appointment> findByPatientMobileNo(@Param("mobileNo") String mobileNo);
}
