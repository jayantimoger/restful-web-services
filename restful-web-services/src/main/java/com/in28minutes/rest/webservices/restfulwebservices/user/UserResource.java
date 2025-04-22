package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findOne(@PathVariable Integer id) {
		User user = service.retriveOneUser(id);
		if(user == null) {
			throw new UserNotFoundException("id : " + id );
		}
		return user;
	}
	
	@PostMapping("/users")
	public void addingUser(@Valid @RequestBody User user) {
		service.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		service.deleteUserDetails(id);
	}
	
}
