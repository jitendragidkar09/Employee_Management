package com.shiavnski.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shiavnski.entities.AuthRequest;
import com.shiavnski.entities.Employee;
import com.shiavnski.service.EmployeeService;
import com.shiavnski.service.JwtService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
    @Autowired
	private JwtService jwtService;

    @Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/add/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee e = employeeService.saveEmployee(employee);
		return e;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId")int employeeId) {
		Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
		Employee employee2 = employee.get();
		return employee2;
	}
	
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("employeeId")int employeeId) {
		Employee updateEmployee = employeeService.updateBook(employee, employeeId);
		return updateEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId")int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
	 @PostMapping("/authenticate")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getUsername());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }


	    }
}
