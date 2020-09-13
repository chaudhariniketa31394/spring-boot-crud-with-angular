package com.example.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.token.entity.Manager;
import com.example.token.repository.ManagerRepository;


@Service
public class ManagerService {

	@Autowired
	ManagerRepository managerRepository;
	
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	
	public Manager create(Manager data) {
		
			Manager newUser = new Manager();
			newUser.setAddress(data.getAddress());
			newUser.setCompany(data.getCompany());
			newUser.setDateOfBirth(data.getDateOfBirth());
			newUser.setUserName(data.getEmail());
			newUser.setFirstName(data.getFirstName());
			newUser.setLastName(data.getLastName());		
			newUser.setPassword(passwordEncoder.encode(data.getPassword()));
			return managerRepository.save(newUser);
		
		

		
	}
}
