package com.example.Blog.playloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private Long id;

	@NotEmpty
	@Size(min=6,message = "username must be min of 6 characters")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;

	@NotEmpty
	@Size(min=6,message = "password must be min of 6 characters")
	private String password;

	@NotEmpty
	private String about;
	
	private Set<CommentDto> comments=new HashSet<>();
}
