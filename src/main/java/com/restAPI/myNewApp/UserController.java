package com.restAPI.myNewApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/hello")
	public String helloMapping() {
		return "Hello ! Welcome to Mintex User Service";
	}
	
	@GetMapping(value ="/allusers")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping(value = "/getuser/{username}")
	public User getAllUsers(@PathVariable("username") String usernameInput) {
		System.out.println(usernameInput);
		return userService.getByUsername(usernameInput);
	}
	
	@PostMapping(value = "/user")
	public User adduser(@RequestBody User newUser) {
		return userService.save(newUser);
	}
}
