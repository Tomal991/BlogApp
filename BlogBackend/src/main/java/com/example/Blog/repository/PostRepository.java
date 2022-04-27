package com.example.Blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog.model.Category;
import com.example.Blog.model.Post;
import com.example.Blog.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findAllByUser(User user);
	List<Post> findAllByCategory(Category category);
}
