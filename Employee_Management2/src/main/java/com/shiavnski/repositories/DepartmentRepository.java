package com.shiavnski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiavnski.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
