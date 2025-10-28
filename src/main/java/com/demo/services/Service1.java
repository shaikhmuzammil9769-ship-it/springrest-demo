package com.demo.services;

import java.util.List;

import com.demo.dtos.UserRequestDTO;
import com.demo.dtos.UserResponseDTO;

public interface Service1 {

	UserResponseDTO createUser(UserRequestDTO request);

	UserResponseDTO updateUser(Integer id, UserRequestDTO request);

	UserResponseDTO getById(Integer id);

	List<UserResponseDTO> getAll();

	String deleteUser(Integer id);

}
