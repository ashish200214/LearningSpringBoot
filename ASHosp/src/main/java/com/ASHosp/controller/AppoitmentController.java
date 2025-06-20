package com.ASHosp.controller;

import com.ASHosp.entity.Appointment;
import com.ASHosp.entity.Patient;
import com.ASHosp.entity.Search;
import com.ASHosp.services.AppointmentSerivce;
import com.ASHosp.services.ServiceLayerPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class AppoitmentController{
    @Autowired
    private ServiceLayerPatient serviceLayerPatient;
    @Autowired
    private AppointmentSerivce serivceLayerAppointment;

    @GetMapping("/appointment/{id}")
    public ModelAndView goToAppointmentPage(@PathVariable int id){
        ModelAndView mv = new ModelAndView();
        Appointment appointment = new Appointment();
        Patient patient =serviceLayerPatient.getPatientById(id);
        appointment.setPatient(patient);
        mv.addObject("appointment",appointment);
        mv.setViewName("appointment");
        return mv;
    }



    @PostMapping("/submitAppointment")
    public ModelAndView saveAppointment(@ModelAttribute Appointment appointment) {
        serivceLayerAppointment.makeAppointment(appointment);   
        ModelAndView mv = new ModelAndView("appointmentSuccess");
        mv.addObject("appointment", appointment);
        Patient patient = appointment.getPatient();
        mv.addObject("patient", patient);
        System.out.println(patient.toString());
        return mv;
    }

    @GetMapping("/allAppointment")
    public ModelAndView allAppointment() {
        ModelAndView mv =new ModelAndView();
        List<Appointment> list = serivceLayerAppointment.getAllAppointment();

        mv.addObject("appointments", list);
        mv.addObject("search",new Search());
        mv.setViewName("allAppointment");
        return mv;
    }

    @PostMapping("/searchAppointment")
    public ModelAndView searchAppointment(@ModelAttribute Search search){
        List<Appointment> appointments= serivceLayerAppointment.findByPatientMobileNo(search);
        ModelAndView mv = new ModelAndView();
        mv.addObject("appointments",appointments);
        mv.setViewName("searchResultOfAppointment");
        return mv;
    }

    @GetMapping("/deleteApp/{id}")
    public String deleteAppointment(@PathVariable int id){
        serivceLayerAppointment.deleteAppointment(id);
        return "redirect:/allAppointment";
    }

}
