package com.example.Blog.service;

import java.util.List;

import com.example.Blog.playloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createcategory(CategoryDto categoryDto);

	public List<CategoryDto> getAllCategories();

	public CategoryDto getCategoryById(Long categoryId);

	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

	public void deleteCategory(Long categoryId);
}
