package com.example.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
