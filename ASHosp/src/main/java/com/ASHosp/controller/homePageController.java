package com.ASHosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ASHosp.entity.Patient;
import com.ASHosp.services.ServiceLayerPatient;
import com.ASHosp.entity.Search;


@Controller
public class homePageController {
    @Autowired
    private ServiceLayerPatient service;
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/register")
    public ModelAndView goToRegisterPage() {
        Patient patient = new Patient();
        ModelAndView mv = new ModelAndView("registeration");
        mv.addObject("patient", patient);
        return mv;
    }

    @GetMapping("/display")
    public ModelAndView goToDisplayPage() {
        ModelAndView mv = new ModelAndView("display");
        mv.addObject("patients", service.getAllPatient());
        mv.addObject("search",new Search());
        return mv;
    }




    
}
