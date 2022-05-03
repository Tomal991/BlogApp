package com.example.Blog.playloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.Blog.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class PostDto {

	private Long postId;
	
	private String title;

	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
	
}
