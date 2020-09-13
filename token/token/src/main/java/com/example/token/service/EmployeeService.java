package com.example.token.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.token.entity.Employee;
import com.example.token.repository.EmployeeRepository;
import com.example.token.repository.ManagerRepository;


@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	public Employee create(String mnagerid, Employee data) {
		
		Employee newUser = new Employee();
		newUser.setAddress(data.getAddress());		
		newUser.setDateOfBirth(data.getDateOfBirth());		
		newUser.setFirstName(data.getFirstName());
		newUser.setLastName(data.getLastName());		
		newUser.setManager(managerRepository.findByUserName(mnagerid));
		newUser.setEmpId(data.getEmpId());
		return employeeRepository.save(newUser);
	
	

	
}

	public boolean deleteByEmpid(Long empid) {	
		Employee user = employeeRepository.findEmployeeByEmpId(empid);
		if (user != null) {
			employeeRepository.delete(user);
			return true;
		} else {
			return false;
		}
		
	}

	
	
	public Employee updateEmployee(Employee data) {
		Employee user = employeeRepository.findEmployeeById(data.getId());
		if (user != null) {
			user.setFirstName(data.getFirstName());
			user.setLastName(data.getLastName());			
			user.setDateOfBirth(data.getDateOfBirth());			
			user.setAddress(data.getAddress());
			return employeeRepository.save(user);
		} else {
			return null;
		}
	}
	
	
	public List<Employee> getAllEmployee(Long managerid) {

		return employeeRepository.findEmployeeByManager_Id(managerid);
	}
	
	
	
	
	
	
	
}
