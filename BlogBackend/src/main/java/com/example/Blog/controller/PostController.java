package com.example.Blog.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.Blog.model.Post;
import com.example.Blog.playloads.ApiResponse;
import com.example.Blog.playloads.CategoryDto;
import com.example.Blog.playloads.PostDto;
import com.example.Blog.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/category/{categoryId}/user/{userId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long categoryId,
			@PathVariable Long userId) {
		PostDto createPost = this.postService.createPost(postDto,categoryId,userId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto>postDtos=this.postService.getAllPosts();
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	
	public ResponseEntity<PostDto> getByPostId(@PathVariable Long postId){
		PostDto postDto=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	//getPostsByCategory
		@GetMapping("/category/{categoryId}")
		public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId){
			List<PostDto>postDtos=this.postService.getPostByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
			
		}
	
	//getPostsByUser
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId){
		List<PostDto>postDtos=this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{postId}")
	public ApiResponse deletePost(@PathVariable Long postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is deleted successfully",true);
	}
	
	@PutMapping("{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Long postId){
		PostDto updatedPost=this.postService.updatepost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
				
	}
	
}
