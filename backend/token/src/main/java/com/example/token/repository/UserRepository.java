package com.example.token.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.token.entity.User;









@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    
    public List<User> findByType(String type);



	public User findByIdAndType(Long id, String type);

	

	public User findByUserName(String username);



	public User findByUserNameAndType(String email, String string);

	
	
}
//Page<Comment> findByPostId(Long postId, Pageable pageable);
