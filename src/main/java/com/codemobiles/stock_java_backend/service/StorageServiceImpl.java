package com.codemobiles.stock_java_backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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
		return null;
	}

}
