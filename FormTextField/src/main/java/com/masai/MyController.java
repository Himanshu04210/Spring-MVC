package com.masai;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/Form")
	public String formLogin(Model model) {
		Employees employee = new Employees();
		
		model.addAttribute("employee", employee);
		return "Form";
	}
	
	@PostMapping("/submitform")
	public String submitform(@ModelAttribute("employee") Employees employee) {
		return "credential-page";
	}
	

}
