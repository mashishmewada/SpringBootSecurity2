package com.learn.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.springsecurity.models.User;
import com.learn.springsecurity.repo.UserRepository;

@SpringBootApplication
public class LearnSpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		//user.setUsername();
		user.setUserName("ashish");
		user.setPassword(this.passwordEncoder.encode("ashish"));
		user.setEmail("ashish@gmail.com");
		user.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user);
		
		
		User user1 = new User();
		user1.setUserName("deepa");
		user1.setPassword(this.passwordEncoder.encode("deepa"));
		user1.setEmail("deepa@gmail.com");
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
	}

}
