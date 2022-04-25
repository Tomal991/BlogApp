package com.example.Blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog.playloads.ApiResponse;
import com.example.Blog.playloads.UserDto;
import com.example.Blog.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserbyId(@PathVariable Long userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Long userId){
		 UserDto updatUserDto=this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatUserDto);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserbyId(@PathVariable Long userId){
		
		 this.userService.deleteUser(userId); 
		 return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
}
