package com.codemobiles.stock_java_backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.codemobiles.stock_java_backend.exception.StorageException;

@Service
public class StorageServiceImpl implements StorageService {
	
	//default value = images กรณีที่ลืมใส่ path
	@Value("${app.upload.path: images}")
	private String path;
	private Path rootLocation;
	
	@Override
	public void init() {
		//ไป get path (app.upload.path) จาก application.properties มา
		this.rootLocation = Paths.get(path);
		//ทำการสร้าง directory
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException ex) {
			throw new StorageException("Cloud not init storage, "+ ex.getMessage());
		}
	}
	
	@Override
	public String store(MultipartFile file) {
		if(file == null || file.isEmpty()) {
			return null;
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			//ป้องกันไม่ให้ไป upload ใน directory ก่อนหน้า
			if (fileName.contains("..")) {
				throw new StorageException("Path outside current directory");
			}
			fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			
			//return ชื่อรูปที่จะเอาไปเก็บที่ database
			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
				return fileName;
			}
		} catch (IOException ex) {
			throw new StorageException("Failed to store file : "+ fileName + ex.getMessage());
		}
	}

}
