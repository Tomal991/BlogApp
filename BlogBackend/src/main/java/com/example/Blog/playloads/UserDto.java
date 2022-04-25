package com.example.Blog.playloads;

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

	private String name;

	private String email;

	private String password;

	private String about;
}
