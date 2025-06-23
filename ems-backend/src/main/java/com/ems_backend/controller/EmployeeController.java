package com.ems_backend.controller;

import com.ems_backend.dto.EmployeeDto;
import com.ems_backend.service.EmployeeServiceImpp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpp service;

    @GetMapping("/getAllEmp")
    public String getAllEmployee(Model map){
        //checked working fine.
         List<EmployeeDto> dto= service.getAllEmployee();
         map.addAttribute("emps",dto);

         return "display-all-employee";

    }

    @GetMapping("/getEmp/{id}")
    public ResponseEntity<EmployeeDto> getSingleUser(@PathVariable  Long id){
        //checked working fine.
        EmployeeDto dto=service.getEmployee(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/addEmp")
    public String addEmployee(Model model){
        EmployeeDto dto = new EmployeeDto();
        model.addAttribute("emp", dto);
        

       return "addEmployee";
    }

    @GetMapping("/submit")
    public String submit(@ModelAttribute EmployeeDto dto){
        
        return "submit-page";
    }

    //Handler for update
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<EmployeeDto> updateEmp(@PathVariable Long id,@RequestBody EmployeeDto dto){
         EmployeeDto dto2= service.updateEmployee(id,dto);
        return ResponseEntity.ok(dto2);

    }

    @DeleteMapping("/deleteEmp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteUser(id));
    }
}
