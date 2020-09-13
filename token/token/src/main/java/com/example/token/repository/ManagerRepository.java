package com.example.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.token.entity.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Manager findByUserName(String mnagerid);

}
