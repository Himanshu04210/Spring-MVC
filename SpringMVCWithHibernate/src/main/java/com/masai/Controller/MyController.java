package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.masai.Entities.Employees;
import com.masai.Repository.EmployeeDao;

@Controller
public class MyController {

	@Autowired
	private EmployeeDao employeeDao;
	
	
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
	
	@GetMapping("/employees")
	public String retriveAllEmployeeHandler(Model model) {
		List<Employees> employees = employeeDao.getAllEmployees();
		model.addAttribute("employees", employees);
		
		
		return "checkDetail";
	}
	
}	
