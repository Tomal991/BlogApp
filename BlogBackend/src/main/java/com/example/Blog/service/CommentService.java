package com.example.Blog.service;

import com.example.Blog.playloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Long postId,Long userId);
	void deleteComment(Long commentId);
}
