package com.ashish.thymeleaf_tutorial;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashish.thymeleaf_tutorial.model.User;






@Controller
public class ControllerCustom {

    @GetMapping("/variable-expression")
    public String variableExpression(Model model) {
        User u = new User();
        u.setName("ashish");
        u.setEmail("ashish@gmail.com");
        u.setGender("Male");

        model.addAttribute("user",u);
        return "variable";
    }

    @GetMapping("/message")
    public String messageExpression() {
        return "message";
    }
    
    @GetMapping("link-expression")
    public String toHandleLinkExpression(Model model){
        model.addAttribute("id",1);
        return "linkexp";
    }
    
    @GetMapping("/fragment")
    public String getMethodName() {
        return "fragment-expression";
    }
    
    //handler method
    @GetMapping("/list")
    public String getList(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ashish","ashish@gmail.com","ADMIN","Male"));
        
        users.add(new User("suyash","suyash@gmail.com","USER","Male"));
        
        users.add(new User("Saroj","ashish@gmail.com","USER","Male"));
        model.addAttribute("users", users);
        return "showUser";
    }  

    @GetMapping("/checkAge")
    public String checkAgeOfUser(Model model){
        model.addAttribute("age", 18);
        return "check";
    }

    @GetMapping("/switch-case")
    public String switchCase(Model model){
        User user = new User("Ashish","ashish@gmail.com","USER","MALE");
        model.addAttribute("user", user);

        return "switch-case-learning";
    }
    
    
}
