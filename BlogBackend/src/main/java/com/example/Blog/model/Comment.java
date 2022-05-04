package com.example.Blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	
	private String content;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private User user;
	
	
	
}
