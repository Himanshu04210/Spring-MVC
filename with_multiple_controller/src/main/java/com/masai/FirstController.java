package com.masai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/hello1")
	public String hello1Handler() {
		return "controller1";
	}
	
}	
