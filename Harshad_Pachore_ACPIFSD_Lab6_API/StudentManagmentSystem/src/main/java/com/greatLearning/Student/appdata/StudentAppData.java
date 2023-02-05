package com.greatLearning.Student.appdata;

import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatLearning.Student.entity.Role;
import com.greatLearning.Student.entity.User;
import com.greatLearning.Student.repository.UserRepository;

@Configuration
public class StudentAppData {

	private final UserRepository userJpaRepository;

	private final PasswordEncoder passwordEncoder;

	public StudentAppData(UserRepository userJpaRepository, PasswordEncoder passwordEncoder) {
		this.userJpaRepository = userJpaRepository;
		this.passwordEncoder = passwordEncoder;

	}

	@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void insertAppData(ApplicationReadyEvent event) {

		User testAdmin = new User("admin", this.passwordEncoder.encode("admin"));
		User testUser = new User("user", this.passwordEncoder.encode("user"));
		

		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");

		testAdmin.addRole(userRole);
		testAdmin.addRole(adminRole);

		testUser.addRole(userRole);
		

		this.userJpaRepository.save(testAdmin);
		this.userJpaRepository.save(testUser);
		System.out.println("Started...");

	}
}