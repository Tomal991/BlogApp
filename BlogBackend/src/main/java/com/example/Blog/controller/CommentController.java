package com.example.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Blog.model.Comment;
import com.example.Blog.playloads.ApiResponse;
import com.example.Blog.playloads.CommentDto;
import com.example.Blog.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto commentDto,@PathVariable Long postId ){
		
		CommentDto commentDto2=this.commentService.createComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(commentDto2,HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted successfully",true),HttpStatus.OK);
	}
}
