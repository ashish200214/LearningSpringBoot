package com.ASHosp.services;

import java.util.List;

import com.ASHosp.entity.Patient;
import com.ASHosp.entity.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ASHosp.entity.Appointment;
import com.ASHosp.repository.AppoitmentRepository;

@Service
public class AppointmentSerivce {
    @Autowired
    private AppoitmentRepository repository;
    
    public void makeAppointment(Appointment appointment){
        repository.save(appointment);
    }

    public List<Appointment> getAllAppointment() {
        return repository.findAll();
    }

    public void deleteAppointment(int id) {
        repository.deleteById(id);
    }



    public  List<Appointment> findByPatientMobileNo(Search search) {
        return repository.findByPatientMobileNo(search.getMobileNo());
    }
}
