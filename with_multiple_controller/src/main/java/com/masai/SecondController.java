package com.masai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	
	@GetMapping("/hello2")
	public String hello2() {
		return "controller2";
	}
	
}
