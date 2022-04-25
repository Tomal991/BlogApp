package com.example.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
