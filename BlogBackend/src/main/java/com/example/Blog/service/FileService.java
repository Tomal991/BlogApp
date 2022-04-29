package com.example.Blog.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String uploadFile(String path,MultipartFile multipartFile) throws IOException;
	
	InputStream getResource(String path,String filename)throws FileNotFoundException;
	
}
