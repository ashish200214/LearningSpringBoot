package com.ASHosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ASHosp.entity.Patient;
import com.ASHosp.services.ServiceLayerPatient;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UpdatePatient {
    @Autowired
   private ServiceLayerPatient service;
    @GetMapping("/update/{id}")
    public ModelAndView updatePatient(@PathVariable int id){
        ModelAndView mv = new ModelAndView("updatePatient");
        mv.addObject("patient", service.getPatientById(id));
        return mv;
    }

    @PostMapping("/submitUpdate")
    public String submitUpdated(@ModelAttribute Patient patient) {
        service.registerPatient(patient);
        return "redirect:/display";
    }

    
}
