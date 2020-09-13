package com.example.token.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.token.entity.User;
import com.example.token.response.ApiResponse;
import com.example.token.response.LoginCredentials;
import com.example.token.response.UserModel;
import com.example.token.service.UserBusiness;






@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	UserBusiness userBusiness;

	
	@PostMapping("/create-user")
	public ApiResponse<User> create( @RequestBody User data) {
		User user = userBusiness.create(data);
		if (user != null) {
			return new ApiResponse<User>(true, "Created successfully", user);
		} else {
			return new ApiResponse<User>(false, "Internal server error", null);
		}
	}

	
	@GetMapping("/employees")
	public ApiResponse<List<User>> getAllEmployee() {

		return new ApiResponse<List<User>>(true, "Employee list", userBusiness.getAllEmployee());
	}

	@PostMapping("/login")
	public ApiResponse<User> login( @RequestBody LoginCredentials data) {
		return userBusiness.login(data);
		
	}

	
	@DeleteMapping("/delete-employee")
	public ApiResponse<Boolean> deleteEmployee(@RequestBody UserModel user) {
		if (userBusiness.deleteEmployee(user.getId())) {
			return new ApiResponse<Boolean>(true, "Deleted successfully", true);
		} else {
			return new ApiResponse<Boolean>(false, "Can't delete. User not found", false);
		}
	}

	
	@PutMapping("/update-employee")
	public ApiResponse<User> updateEmployee(@RequestBody User data) {
		User user = userBusiness.updateEmployee(data);
		if (user != null) {
			return new ApiResponse<User>(true, "Updated successfully", user);
		} else {
			return new ApiResponse<User>(false, "User not found", null);
		}
	}

}
