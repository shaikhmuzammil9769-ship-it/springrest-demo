package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.UserRequestDTO;
import com.demo.dtos.UserResponseDTO;
import com.demo.entities.User;
import com.demo.repositories.UserRepository;

@Service
public class UserService implements Service1 {

	@Autowired
	public UserRepository userRepo;

	public UserService(UserRepository userRepo) {

		this.userRepo = userRepo;
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO request) {

		// Here I have Called the Request DTO from the Client and used the Entity [user]
		// class to set the value and save in DB

		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setCountry(request.getCountry());
		user.setPassword(request.getPassword());

		User saved = userRepo.save(user);

		// Here I have called the Response DTO to show the only required Data to Client
		// and Hide the sensitive data

		UserResponseDTO dto = new UserResponseDTO();

		dto.setId(user.getId());
		dto.setName(saved.getName());
		dto.setEmail(saved.getEmail());
		dto.setCountry(saved.getCountry());

		return dto;
	}

	@Override
	public UserResponseDTO updateUser(Integer id,UserRequestDTO request) {
		 User user = userRepo.findById(id).orElseThrow();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setCountry(request.getCountry());
		user.setPassword(user.getPassword());
		UserResponseDTO dto = new UserResponseDTO();
		
		User updated = userRepo.save(user);
		
		dto.setId(updated.getId());
		dto.setName(updated.getName());
		dto.setEmail(updated.getEmail());
		dto.setCountry(updated.getCountry());
		
		return dto;
	}

	@Override
	public UserResponseDTO getById(Integer id) {


		User user = userRepo.findById(id).orElseThrow();
		
		UserResponseDTO dto = new UserResponseDTO();
		
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setCountry(user.getCountry());
		
		return dto;
	}

	@Override
	public List<UserResponseDTO> getAll() {
		List<User> users = userRepo.findAll();
		
		List<UserResponseDTO> dtos = new ArrayList<UserResponseDTO>();
		
		for(User user:users) {
			
			UserResponseDTO dto = new UserResponseDTO();
			
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setCountry(user.getCountry());
			
			dtos.add(dto);
			
			
		}
		return dtos;
	}

	@Override
	public String deleteUser(Integer id) {
		
		userRepo.deleteById(id);
		
		return  "User no "+id +" deleted Sucessfully";
	}

	

}
