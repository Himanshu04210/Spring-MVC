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
		System.out.println("working fine....");
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
	public void submitUserCredintial(@ModelAttribute("user") Users user, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(userDao.findUserByEmail(user.getEmail()) == null)
			userDao.registerUser(user);
		
		
		String contextPath = request.getContextPath();
		
		
		response.sendRedirect(contextPath + "/dashboard");
		

	}
	
	
	@GetMapping("/dashboard")
	public String dashboardHandler(Model model) {
		List<Users> users = userDao.getAllUsers();
		model.addAttribute("userList", users);
		return "dashboard";
	}
	
	
	
}	
