package com.in28minutes.rest.webservices.restfulwebservices.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;

	//List<User> retrieveAllUsers(){
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//User retrieveUser(int id){
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User  user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id- "+id);
		
		return user;
	}
	
	//HATEOAS: get user by id and get other link
	@GetMapping("/usersById/{id}")
	public Resource<User> retrieveUserById(@PathVariable int id){
		User  user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id- "+id);
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	//input - details of user
	//output - CREATED & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//Delete user by id
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id){
		User  user = service.deleteById(id);
		if(user == null)
			throw new UserNotFoundException("id- "+id);
		return user;
	}
}
