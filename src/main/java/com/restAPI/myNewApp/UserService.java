package com.restAPI.myNewApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserService extends JpaRepository<User, Integer> {

	@Query(name="getAllUsers", value = "select u from User u")
	public List<User> getAllUsers();
	
	public User getByUsername(String username);
}
