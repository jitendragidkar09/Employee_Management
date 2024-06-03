package com.shiavnski.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shiavnski.entities.Department;
import com.shiavnski.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		Department d = departmentService.saveDepartment(department);
		return d;
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		List<Department> departments = departmentService.getAllDepartments();
		return departments;
	}
	
	@GetMapping("/departments/{departmentId}")
	public Department getDepartment(@PathVariable("departmentId")int departmentId) {
		Optional<Department> department = departmentService.getDepartmentById(departmentId);
		Department department2 = department.get();
		return department2;
	}
	
	@PutMapping("/departments/{departmentId}")
	public Department updateDepartment(@RequestBody Department department,@PathVariable("departmentId")int departmentId) {
		Department updateDepartment = departmentService.updateDepartment(department, departmentId);
		return updateDepartment;
	}
	
	@DeleteMapping("/departments/{departmentId}")
	public void deleteDepartment(@PathVariable("departmentId")int departmentId) {
		departmentService.deleteDepartment(departmentId);
	}
}
