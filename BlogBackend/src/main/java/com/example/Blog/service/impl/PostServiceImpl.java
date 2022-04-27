package com.example.Blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog.exceptions.ResourceNotFoundException;
import com.example.Blog.model.Category;
import com.example.Blog.model.Post;
import com.example.Blog.model.User;
import com.example.Blog.playloads.PostDto;
import com.example.Blog.repository.CategoryRepository;
import com.example.Blog.repository.PostRepository;
import com.example.Blog.repository.UserRepository;
import com.example.Blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public PostDto createPost(PostDto postDto,Long categoryId,Long userId) {
		
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
		
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		
		Post post=this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post newPost=this.postRepository.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public List<Post> getAllPosts() {
		
		
		
		return null;
	}

	@Override
	public Post getPostById(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatepost(PostDto postDto, Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Long postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getPostByCategory(Long categoryId) {
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
		List<Post>posts=this.postRepository.findAllByCategory(category);		
		
		 List<PostDto> postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Long userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
		List<Post>posts=this.postRepository.findAllByUser(user);		
		
		 List<PostDto> postDtos=posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
		 
	}

	@Override
	public List<Post> searchPost(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
