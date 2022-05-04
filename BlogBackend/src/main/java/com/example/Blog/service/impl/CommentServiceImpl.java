package com.example.Blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Blog.exceptions.ResourceNotFoundException;
import com.example.Blog.model.Comment;
import com.example.Blog.model.Post;
import com.example.Blog.model.User;
import com.example.Blog.playloads.CommentDto;
import com.example.Blog.playloads.PostDto;
import com.example.Blog.repository.CommentRepository;
import com.example.Blog.repository.PostRepository;
import com.example.Blog.repository.UserRepository;
import com.example.Blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Long postId,Long userId) {

		Post post = this.postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment savedComment = this.commentRepository.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Long commentId) {
		Comment comment = this.commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("comment", "commentId", commentId));
		
		this.commentRepository.delete(comment);
	}

}
