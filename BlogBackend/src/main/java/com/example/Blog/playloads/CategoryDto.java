package com.example.Blog.playloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {

	private Long categoryId;
	
	@NotBlank
	@Size(min=5, message = "minimum letters of title will be 5")
	private String categoryTitle;
	
	@NotBlank
	@Size(min=15, message = "minimum letters of description will be 15")
	private String categoryDescription;
	
}
