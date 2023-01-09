package com.greatlearning.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void updateOrAddEmployee(Employee emp) {
		employeeRepository.save(emp);
		
	}

	@Override
	public void deteteEmployeeById(int id) {
		employeeRepository.delete(getEmployeeById(id));
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).get();
	}

}
