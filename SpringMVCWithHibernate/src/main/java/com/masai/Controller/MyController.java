package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.masai.Entities.Users;
import com.masai.Repository.UserDao;

@Controller
public class MyController {

	@Autowired
	private UserDao userDao;
	
	
	@GetMapping("/")
	public String welcome() {
		
		/*
		Employees employee = Employees.builder()
								.name("Susheel")
								.address("banki")
								.salary("50000")
								.build();
		
		employeeDao.registerEmployee(employee);
		*/
		
		return "index";
	}
	
	@GetMapping("/users")
	public String retriveAllUserHandler(Model model) {
		List<Users> users = userDao.getAllUsers();
		model.addAttribute("employees", users);
		
		
		return "checkDetail";
	}
	
	
	@GetMapping("/register")
	public String registerUserHandler(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "register";
	}
	
	
	
	@PostMapping("/registerUser")
	public String submitUserCredintial(@ModelAttribute("user") Users user, Model model) {
		if(user != null) {
			userDao.registerUser(user);
			model.addAttribute("name", user.getName());
		}
		model.asMap().remove("user");
		return "register";
	}
	
}	
