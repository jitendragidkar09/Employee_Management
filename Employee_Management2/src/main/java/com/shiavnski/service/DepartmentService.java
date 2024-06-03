package com.shiavnski.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiavnski.entities.Department;
import com.shiavnski.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
			//Save a Department
			public Department saveDepartment(Department department) {
				Department department1 = departmentRepository.save(department);
				return department1 ;
			}
			
			//Get All Departments
			public List<Department> getAllDepartments(){
				return (List<Department>) departmentRepository.findAll();
			}
			
			//Get Department by Id
			public Optional<Department> getDepartmentById(int id){
				return departmentRepository.findById(id);
			}
			
			//Update the details of a Department
			public Department updateDepartment(Department department,int departmentId) {
				return departmentRepository.save(department);
			}
			
			//Delete a Department
			public void deleteDepartment(int departmentId) {
				departmentRepository.deleteById(departmentId);
}
}
