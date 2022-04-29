package com.example.Blog.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Blog.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(String path, MultipartFile multipartFile) throws IOException {
		
		String fileName=multipartFile.getOriginalFilename();
		
		String randomID=UUID.randomUUID().toString();
		String fileName1=randomID.concat(fileName.substring(fileName.lastIndexOf(".")));
		
		
		String filePath=path+File.separator+fileName1;
		
		
		File file=new File(path);
		
		if(!file.exists()) {
			file.mkdir();
			
		}
		
		Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	 @Override
	    public InputStream getResource(String path, String filename) throws FileNotFoundException {
	        String fullPath=path+File.separator+filename;
	        InputStream is=new FileInputStream((fullPath));
	        return is;
	    }

}
