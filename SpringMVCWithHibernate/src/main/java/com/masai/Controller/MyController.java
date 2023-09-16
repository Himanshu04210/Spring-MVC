package com.masai.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.masai.Entities.Users;
import com.masai.Repository.UserDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {

	@Autowired
	private UserDao userDao;
	
	
	@GetMapping("/")
	public String welcome() {
		
		/*
		Users user = Users.builder()
					.name("Susheel")
					.address("banki")
					.salary("50000")
					.build();
		
		userDao.registerUser(user);
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
	public String submitUserCredintial(@ModelAttribute("user") Users user, Model model, HttpServletResponse response) throws IOException {
		try {
			Users existingUser = userDao.findUserByEmail(user.getEmail());
			if(existingUser == null) userDao.registerUser(user);
			
		}
		catch(Exception ex) {
			
		}
		
		List<Users> users = userDao.getAllUsers();
		System.out.println(users);
		model.addAttribute("userList", users);
		//response.sendRedirect("dashboard.jsp");
		return "dashboard";

	}
	
	
	
}	
