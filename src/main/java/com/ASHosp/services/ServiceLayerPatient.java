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

    public void delete(int id){
        Patient patient = patientRepo.findById(id).orElse(null);
        patientRepo.delete(patient);
    }

    public Patient getPatientById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

    public List<Patient> searchPatientByMobileNo(String mobileno) {
        return patientRepo.findAllByMobileNo(mobileno).orElse(null);
    }

}
