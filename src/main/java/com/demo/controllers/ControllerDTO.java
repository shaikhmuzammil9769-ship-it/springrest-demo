package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dtos.UserRequestDTO;
import com.demo.dtos.UserResponseDTO;
import com.demo.services.Service1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("test")
@Tag(name = "Test Swagger", description = "This is test swagger parctice using dto ")
public class ControllerDTO {

	
	public Service1 service;

	public ControllerDTO(Service1 service) {
		this.service = service;
	}

	@PostMapping
	@Operation(summary = "Save the User", description = "Add a new user to the system")
	public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {

		return service.createUser(request);

	}

	@PutMapping("/{id}")
	@Operation(summary = "Update the User", description = "Update an existing user in the system")
	public UserResponseDTO updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO request) {
		return service.updateUser(id, request);
	}

	@GetMapping("/getbyid/{id}")
	@Operation(summary = "Get a user by id", description = "It gets a user on the basis of id")
	public UserResponseDTO getById(@PathVariable Integer id) {
		return service.getById(id);

	}
	
	
	@GetMapping("/getAll")
	@Operation(summary = "Get all users", description = "Get all users from the system")
	public List<UserResponseDTO> getAll() {
		return service.getAll();
		
		
		
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a user", description = "Delete a user from the system")
	public String deleteUser(@PathVariable Integer id) {
		return service.deleteUser(id);
		
		
		
	}
	
	
	

}
