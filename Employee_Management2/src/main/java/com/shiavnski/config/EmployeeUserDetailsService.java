package com.shiavnski.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shiavnski.entities.Employee;
import com.shiavnski.repositories.EmployeeRepository;

@Component
public class EmployeeUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employee = employeeRepository.findByemployeeName(username);
        return employee.map(EmployeeUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
	}

}
