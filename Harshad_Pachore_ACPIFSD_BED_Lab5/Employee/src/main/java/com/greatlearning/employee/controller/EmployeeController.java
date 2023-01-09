package com.greatlearning.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.services.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public String getAllEmployee(Model model) {
		List<Employee> employee = service.getAllEmployee();
		model.addAttribute("employees",employee);
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String updateEmployee(Model model,@PathVariable("id") Integer id) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "edit_employee";
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		service.deteteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute(name = "employee") Employee employee) {
			service.updateOrAddEmployee(employee);
		return "redirect:/employees";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@ModelAttribute(name = "employee") Employee employee,@PathVariable("id") Integer id) {
		Employee employeeNew = service.getEmployeeById(id);
		if(employee.getId() == employeeNew.getId()) {
			employeeNew.setFirstName(employee.getFirstName());
			employeeNew.setLastName(employee.getLastName());
			employeeNew.setEmail(employee.getEmail());
		}
		service.updateOrAddEmployee(employeeNew);
		return "redirect:/employees";
	}
	

}
