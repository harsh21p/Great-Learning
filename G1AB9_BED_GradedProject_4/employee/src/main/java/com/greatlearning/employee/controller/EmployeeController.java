package com.greatlearning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.model.ErrorResponse;
import com.greatlearning.employee.responseHandler.HttpStatusCode;
import com.greatlearning.employee.service.EmployeeService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
  
	@Autowired
    EmployeeService employeeService;
    
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.getEmployeeByFirstName(name);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/sort{order}")
    public ResponseEntity<List<Employee>> getEmployeeSorted(@PathVariable("order") String order) {
        List<Employee> employees = employeeService.getAllEmployeesSorted(order);
        return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
    
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        employee =  employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employee));
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
        return "deleted employee with id: " +id;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception exc) throws ParseException {
        ErrorResponse response = new ErrorResponse(400, exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, new HttpStatusCode(400).getHttpStatus());
    }
}
















