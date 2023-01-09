package com.greatlearning.employee.services;

import java.util.List;

import com.greatlearning.employee.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	
	public void updateOrAddEmployee(Employee emp);
	
	public void deteteEmployeeById(int id);
	
	public Employee getEmployeeById(int id);
}
