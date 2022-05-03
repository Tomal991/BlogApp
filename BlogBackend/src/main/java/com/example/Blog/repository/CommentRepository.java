package com.example.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
