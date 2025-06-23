package com.ashish.thymeleaf_tutorial;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashish.thymeleaf_tutorial.model.UserForm;


@Controller
public class FormController {
    //handler method to handle user registeration page request
    @GetMapping("/register")
    public String handleForm(Model model){
        //empyt model object 
        UserForm form = new UserForm();
        model.addAttribute("user",form);
        List<String> list = Arrays.asList("Developer","Tester","Architect");
        model.addAttribute("listProfession", list);

        return "register-form";
        

    }

    @PostMapping("/register/save")
    public String handleFormSubmission(Model model,@ModelAttribute("form") UserForm form){
        model.addAttribute("form", form);

        return "display";
    }
}   
