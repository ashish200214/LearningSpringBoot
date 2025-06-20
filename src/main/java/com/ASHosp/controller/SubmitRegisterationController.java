package com.ASHosp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ASHosp.entity.Patient;
import com.ASHosp.services.ServiceLayerPatient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SubmitRegisterationController {
    @Autowired
    ServiceLayerPatient service;
    @PostMapping("/submit_registerationForm")
    public String submitRegisteration(@ModelAttribute Patient patient, RedirectAttributes attributes) {
      service.registerPatient(patient);
    List<Patient> patients = service.getAllPatient();
    attributes.addFlashAttribute("patients",patients);
    return "redirect:/display";

    }   
    
}
