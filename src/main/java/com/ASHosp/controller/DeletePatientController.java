package com.ASHosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ASHosp.services.ServiceLayerPatient;

@Controller
public class DeletePatientController {
    @Autowired
    private ServiceLayerPatient service;
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id){
        service.delete(id);
        return "redirect:/display";
    }
}
