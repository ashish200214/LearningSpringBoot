package com.ASHosp.controller;

import com.ASHosp.entity.Appointment;
import com.ASHosp.entity.Patient;
import com.ASHosp.entity.Search;
import com.ASHosp.services.ServiceLayerPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    ServiceLayerPatient service;
    @GetMapping("/search")
    public ModelAndView goToSearchPage(){
        ModelAndView mv = new ModelAndView("searchPatient");
        Search search = new Search();
        mv.addObject("search",search);
        return mv;
    }

    @PostMapping("/searchSubmit")
    public ModelAndView searchPatientById(@ModelAttribute Search search){

        ModelAndView mv = new ModelAndView();
        List<Patient> patients=service.searchPatientByMobileNo(search.getMobileNo());


        if(patients.size()>=1){
            mv.addObject("patients",patients);
            mv.setViewName("searchResult");
        }
        else{
            mv.setViewName("nopatient_error");
        }
        return mv;
    }
}
