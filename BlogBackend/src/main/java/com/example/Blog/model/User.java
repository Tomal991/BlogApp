package com.example.Blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	
	

	
	
	
	
}
