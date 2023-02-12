package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Employee;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee employee);
    public void deleteEmployeeById(int id);
    public Employee getEmployeeById(int id);

    public int getCount();
    List<Employee> getEmployeeByFirstName(String name);

    public List<Employee> getAllEmployeesSorted(String order);
}