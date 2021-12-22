package com.learn.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springsecurity.models.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUserName(String username);

}
