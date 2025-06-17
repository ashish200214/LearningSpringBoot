package com.ASHosp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ASHosp.entity.Patient;
import com.ASHosp.services.ServiceLayerPatient;


@Controller
public class SubmitRegisterationController {
    @Autowired
    ServiceLayerPatient service;
    @PostMapping("/submit_registerationForm")
    public ModelAndView submitRegisteration(@ModelAttribute Patient patient) {
        ModelAndView mv = new ModelAndView("display");
        
      service.registerPatient(patient);
    List<Patient> patients = service.getAllPatient();
    mv.addObject("patients", patients);
    return mv;
    }   
    
}
