package com.example.Blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Blog.model.Post;
import com.example.Blog.playloads.ApiResponse;
import com.example.Blog.playloads.CategoryDto;
import com.example.Blog.playloads.FileResponse;
import com.example.Blog.playloads.PostDto;
import com.example.Blog.playloads.PostResponse;
import com.example.Blog.service.FileService;
import com.example.Blog.service.PostService;
import com.example.Blog.utils.Constants;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/category/{categoryId}/user/{userId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long categoryId,
			@PathVariable Long userId) {
		PostDto createPost = this.postService.createPost(postDto, categoryId, userId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber", defaultValue = Constants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIR, required = false) String sortDir) {
		PostResponse postResponse = this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

	@GetMapping("/{postId}")

	public ResponseEntity<PostDto> getByPostId(@PathVariable Long postId) {
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	// getPostsByCategory
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId) {
		List<PostDto> postDtos = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);

	}

	// getPostsByUser
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Long userId) {
		List<PostDto> postDtos = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);

	}

	@DeleteMapping("{postId}")
	public ApiResponse deletePost(@PathVariable Long postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is deleted successfully", true);
	}

	@PutMapping("{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long postId) {
		PostDto updatedPost = this.postService.updatepost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);

	}

	@GetMapping("/search/{title}")
	public ResponseEntity<List<PostDto>> searchByTitle(@PathVariable("title") String title) {
		List<PostDto> postDto = this.postService.searchPost(title);
		return new ResponseEntity<List<PostDto>>(postDto, HttpStatus.OK);
	}

	// image upload

	@PostMapping("/file/upload/{postId}")
	public ResponseEntity<PostDto> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long postId)
			throws IOException {

		PostDto postDto = this.postService.getPostById(postId);
		String fileName = this.fileService.uploadFile(path, file);
		
		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatepost(postDto, postId);

		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}
	
	@GetMapping(value = "/file/{fileName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException {
       InputStream resource = this.fileService.getResource(path, fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
