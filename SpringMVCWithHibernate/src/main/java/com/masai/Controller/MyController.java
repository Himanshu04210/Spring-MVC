package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.Entities.Users;
import com.masai.Entities.VaccinatedUsers;
import com.masai.Repository.UserDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {

	@Autowired
	private UserDao userDao;
	
	
	@GetMapping("/")
	public String welcome() {
		System.out.println("working....");
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
		
		
		response.sendRedirect(contextPath + "/register");
		

	}
	
	
	@GetMapping("/dashboard")
	public String dashboardHandler(Model model) {
		List<Users> users = userDao.getAllUsers();
		model.addAttribute("userList", users);
		return "dashboard";
	}
	
	@GetMapping("/delete")
	public String deleteUserHandler(@RequestParam int id) {
		userDao.deleteUserById(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/vaccinatedUser")
	public String vaccinatedUser(@RequestParam int id) {
		System.out.println("vaccinate user is working " +id);
		
		Users user = userDao.deleteUserById(id);
		
		if(user != null) {
			VaccinatedUsers vaccinatedUsers = VaccinatedUsers.builder()
					.id(id)
					.name(user.getName())
					.age(user.getAge())
					.address(user.getAddress())
					.designation(user.getDesignation())
					.email(user.getEmail())
					.priority(user.getPriority())
					.vaccine(user.getVaccine())
					.build();
			
			userDao.addVaccinatedUser(vaccinatedUsers);
		}
		
		return "redirect:/vaccinatedUsers";
	}
	
	
	@GetMapping("/vaccinatedUsers")
	public String getAllVaccinatedUsers(Model model) {
		List<VaccinatedUsers> vaccinatedUsers = userDao.getAllVaccinatedUsers();
		model.addAttribute("vaccinatedUser", vaccinatedUsers);
		return "vaccinatedPage";
	}
	
	
}	
