package com.shiavnski.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_email")
	private String employeeEmail;
	
	@Column(name="employee_password")
	private String employeePassword;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department; 
	
	private String roles;
	
}