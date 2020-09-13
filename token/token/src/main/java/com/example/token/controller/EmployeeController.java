package com.example.token.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.token.entity.Employee;
import com.example.token.response.ApiResponse;
import com.example.token.service.EmployeeService;
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService EmployeeService;
	
	
	@PostMapping("/create-employee")
	public ApiResponse<Employee> create(@RequestParam(value = "managerid") String managerid, @RequestBody Employee data) {
		Employee user = EmployeeService.create(managerid,data);
		if (user != null) {
			return new ApiResponse<Employee>(true, "Created successfully", user);
		} else {
			return new ApiResponse<Employee>(false, "Internal server error", null);
		}
	}
	
	
	@PutMapping("/update-employees")
	public ApiResponse<Employee> updateEmployee(@RequestBody Employee data) {
		Employee user = EmployeeService.updateEmployee(data);
		if (user != null) {
			return new ApiResponse<Employee>(true, "Updated successfully", user);
		} else {
			return new ApiResponse<Employee>(false, "User not found", null);
		}
	}
	
	
	
	@GetMapping("/all-employees")
	public ApiResponse<List<Employee>> getAllEmployee(@RequestParam(value = "manager") Long manager) {

		return new ApiResponse<List<Employee>>(true, "Employee list", EmployeeService.getAllEmployee(manager));
	}
	
	
	
	@DeleteMapping("/delete-employees")
	public ApiResponse<Boolean> deleteEmployee(@RequestBody Long empid) {
		if (EmployeeService.deleteByEmpid(empid)) {
			return new ApiResponse<Boolean>(true, "Deleted successfully", true);
		} else {
			return new ApiResponse<Boolean>(false, "Can't delete. User not found", false);
		}
	}
}
