package com.example.Blog.service;

import java.util.List;

import com.example.Blog.playloads.UserDto;


public interface UserService {

	UserDto createUser(UserDto user);
		
	UserDto getUserById(Long id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto user,Long id);
	
	void deleteUser(Long id);
}
