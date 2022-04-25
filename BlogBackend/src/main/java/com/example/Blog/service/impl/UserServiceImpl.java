package com.example.Blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog.exceptions.ResourceNotFoundException;
import com.example.Blog.model.User;
import com.example.Blog.playloads.UserDto;
import com.example.Blog.repository.UserRepository;
import com.example.Blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveduser = this.userRepository.save(user);
		return this.userToDto(saveduser);
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updatedUser = this.userRepository.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);

		return userDto1;
	}

	@Override
	public void deleteUser(Long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		this.userRepository.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
