package com.example.Blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog.model.Post;
import com.example.Blog.playloads.CategoryDto;
import com.example.Blog.playloads.PostDto;
import com.example.Blog.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/category/{categoryId}/user/{userId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long categoryId,
			@PathVariable Long userId) {
		PostDto createPost = this.postService.createPost(postDto,categoryId,userId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	//getPostsByCategory
		@GetMapping("/category/{categoryId}/post")
		public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId){
			List<PostDto>postDtos=this.postService.getPostByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
			
		}
	
	//getPostsByUser
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId){
		List<PostDto>postDtos=this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
		
	}
	
}
