package com.shiavnski.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;

}
