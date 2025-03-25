package com.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileService {
    public String uploadFile(String path, MultipartFile file) throws IOException {
        String fileName= file.getOriginalFilename();
        String filePath=path+ File.separator +fileName;
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName;
    }
}
