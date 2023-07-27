package com.masai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
		
	}
	
	@GetMapping("/addnumber")
	public String addNumber() {
		return "addnumber";
	}
	
	
	@GetMapping("/add")
	public String add(Integer num1, Integer num2, Model model) {
		Integer result = num1+num2;
		
		model.addAttribute("ResultData", result);
		return "output";
		
	}
	
	@GetMapping("/loginPage") 
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/loginData")
	public String loginCre(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) return "success";
		return "error";
	}
	
	
}


