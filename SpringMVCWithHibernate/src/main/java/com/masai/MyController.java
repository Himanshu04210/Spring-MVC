package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.masai.Entity.Employees;
import com.masai.Repository.EmployeeDao;


@Controller
public class MyController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	
	@PostMapping("/register")
	public String RegisterEmployee(Employees employee) {
		
		employeeDao.registerEmployee(employee);
		
		return "register";
	}
	
	
	@GetMapping("/employees")
	public String allEmployeeHandler() {
		List<Employees> employees = employeeDao.getAllEmployees();
		
		return "allEmployee";
		
		
	}
}
