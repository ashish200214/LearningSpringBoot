package com.asent.customerDetails.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String redirectToAsent() {
        return "redirect:/asent";
    }
}

