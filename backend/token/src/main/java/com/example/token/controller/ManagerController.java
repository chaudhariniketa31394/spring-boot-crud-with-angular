package com.example.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.token.entity.Manager;
import com.example.token.response.ApiResponse;
import com.example.token.service.ManagerService;


@RestController
public class ManagerController {
	
	
	
	
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/create-manager")
	public ApiResponse<Manager> create(@RequestBody Manager data) {
		Manager user = managerService.create(data);
		if (user != null) {
			return new ApiResponse<Manager>(true, "Created successfully", user);
		} else {
			return new ApiResponse<Manager>(false, "Internal server error", null);
		}
	}
}
