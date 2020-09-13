package com.example.token.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.token.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findEmployeeByEmpId(Long empid);

	Employee findEmployeeById(Long id);

	List<Employee> findEmployeeByManager_Id(Long managerid);

}
