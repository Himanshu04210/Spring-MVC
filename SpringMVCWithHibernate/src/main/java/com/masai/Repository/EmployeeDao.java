package com.masai.Repository;

import java.util.List;

import com.masai.Entities.Employees;

public interface EmployeeDao {
	public Employees registerEmployee(Employees employee);
	public List<Employees> getAllEmployees();
}
