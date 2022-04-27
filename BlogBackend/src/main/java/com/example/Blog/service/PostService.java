package com.example.Blog.service;

import java.util.List;

import com.example.Blog.model.Post;
import com.example.Blog.playloads.CategoryDto;
import com.example.Blog.playloads.PostDto;

public interface PostService {

	
	 PostDto createPost(PostDto postDto,Long categoryId,Long userId);

	 List<PostDto> getAllPosts();

	 PostDto getPostById(Long postId);

	 PostDto updatepost(PostDto postDto, Long postId);

	 void deletePost(Long postId);
	 
	 List<PostDto> getPostByCategory(Long categoryId);
	 
	 List<PostDto> getPostByUser(Long userid);
	 
	 List<PostDto> searchPost(String title);
	 
	 
}