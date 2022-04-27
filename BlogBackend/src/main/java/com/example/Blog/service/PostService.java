package com.example.Blog.service;

import java.util.List;

import com.example.Blog.model.Post;
import com.example.Blog.playloads.CategoryDto;
import com.example.Blog.playloads.PostDto;

public interface PostService {

	
	 PostDto createPost(PostDto postDto,Long categoryId,Long userId);

	 List<Post> getAllPosts();

	 Post getPostById(Long postId);

	 Post updatepost(PostDto postDto, Long postId);

	 void deletePost(Long postId);
	 
	 List<PostDto> getPostByCategory(Long categoryId);
	 
	 List<PostDto> getPostByUser(Long userid);
	 
	 List<Post> searchPost(String title);
	 
	 
}