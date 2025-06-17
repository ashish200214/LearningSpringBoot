package com.ASHosp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASHosp.entity.Patient;
import com.ASHosp.repository.RepositoryPatient;

@Service
public class ServiceLayerPatient {
    @Autowired
    private RepositoryPatient patientRepo;

    public void registerPatient(Patient patient){
        patientRepo.save(patient);
        
    }

    public List<Patient> getAllPatient(){
        return patientRepo.findAll();
    }

    public void deletePatientById(int id) {
        patientRepo.deleteById(id);
    }

    public Patient getPatientById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

}
