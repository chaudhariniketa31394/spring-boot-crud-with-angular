package com.example.token.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.token.entity.User;
import com.example.token.repository.UserRepository;
import com.example.token.response.ApiResponse;
import com.example.token.response.LoginCredentials;





@Service
public class UserBusiness {

	@Autowired
	UserRepository userRepository;
	
	
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;


	//create user
	public User create(User data) {
		if(data.getPassword() != null) {
			User newUser = new User();
			newUser.setAddress(data.getAddress());
			newUser.setCompany(data.getCompany());
			newUser.setDateOfBirth(data.getDateOfBirth());
			newUser.setUserName(data.getEmail());
			newUser.setFirstName(data.getFirstName());
			newUser.setLastName(data.getLastName());
			newUser.setMobileNo(data.getMobileNo());
			newUser.setType(data.getType());
			newUser.setPassword(passwordEncoder.encode(data.getPassword()));
			return userRepository.save(newUser);
		}else {
			User newUser = new User();
			newUser.setAddress(data.getAddress());
			newUser.setCompany(data.getCompany());
			newUser.setDateOfBirth(data.getDateOfBirth());
			newUser.setUserName(data.getEmail());
			newUser.setFirstName(data.getFirstName());
			newUser.setLastName(data.getLastName());
			newUser.setMobileNo(data.getMobileNo());
			newUser.setType(data.getType());
			return userRepository.save(newUser);
		}
		

		
	}

	/**
	 * 
	 * Get all emplyees
	 * 
	 * @return List
	 */
	public List<User> getAllEmployee() {

		return userRepository.findByType("employee");
	}

	/**
	 * Validating user credentials
	 * 
	 * @param data
	 * @return User
	 */
	public  ApiResponse<User> login(LoginCredentials data) {
		
		String newPass = passwordEncoder.encode(data.getPassword());
		System.out.println("mypasssssssss");
		System.out.println(newPass);

		User existing =  userRepository.findByUserNameAndType(data.getUsername(),"manager");
		System.out.println(existing);
		if(existing != null) {
			Boolean isMatch = passwordEncoder.matches(data.getPassword(),existing.getPassword());
			System.out.println(isMatch);
			if(isMatch) {
				return new ApiResponse<User>(true, "Login successful", existing);
				
			}else {
				return new ApiResponse<User>(true, "invalid credentioals",null );
					       			}
		}else {
			return new ApiResponse<User>(true, "user not found", null);
		}
	}

	/**
	 * Deleting an employee
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean deleteEmployee(Long id) {
		User user = findEmployeeById(id);
		if (user != null) {
			userRepository.delete(user);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Find employee by id
	 * 
	 * @param id
	 * @return User
	 */
	public User findEmployeeById(Long id) {
		return userRepository.findByIdAndType(id, "employee");
	}

	/**
	 * Updating existing employee
	 * 
	 * @param data
	 * @return User
	 */
	public User updateEmployee(User data) {
		User user = findEmployeeById(data.getId());
		if (user != null) {
			user.setFirstName(data.getFirstName());
			user.setLastName(data.getLastName());
			user.setUserName(data.getUserName());
			user.setDateOfBirth(data.getDateOfBirth());
			user.setCompany(data.getCompany());
			user.setAddress(data.getAddress());
			return userRepository.save(user);
		} else {
			return null;
		}
	}
}
