package com.security.LearningSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin/home")
	public String home2() {
		return "admin_home";
	}
	
	@GetMapping("/user/home")
	public String home3() {
		return "user_home";
	}
}
