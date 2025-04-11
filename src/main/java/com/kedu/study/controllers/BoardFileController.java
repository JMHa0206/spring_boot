package com.kedu.study.controllers;

import java.io.File;
import java.net.http.HttpHeaders;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.study.dto.BoardFileDTO;
import com.kedu.study.service.BoardFileService;

import jakarta.annotation.Resource;

@Controller
public class BoardFileController {
	   @Autowired
	    private BoardFileService boardFileService;

	    // 파일 업로드 처리
	    @PostMapping("/uploadFile")
	    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("parentPost") int parentPost) {
	    	 try {
	             // 파일 정보 객체 생성
	             BoardFileDTO boardFileDTO = new BoardFileDTO();
	             boardFileDTO.setParent_post(parentPost);
	             boardFileDTO.setB_oriname(file.getOriginalFilename());

	             // 1. 고유한 파일 이름 생성 (UUID + 원본 파일 이름)
	             String systemFileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
	             
	             // 2. 파일을 저장할 경로 설정
	             String uploadDir = "C:/uploads/";  // 실제 파일이 저장될 디렉토리 경로 (시스템에 맞게 수정)
	             File directory = new File(uploadDir);
	             if (!directory.exists()) {
	                 directory.mkdirs(); // 디렉토리가 없으면 생성
	             }

	             // 3. 파일 저장
	             File destinationFile = new File(uploadDir + systemFileName);
	             file.transferTo(destinationFile);  // 파일 저장

	             // 4. 저장된 파일의 경로와 이름을 DTO에 설정
	             boardFileDTO.setB_sysname(systemFileName);

	             // 5. DB에 파일 정보 저장
	             boardFileService.insertBoardFile(boardFileDTO);

	             return "success"; // 파일 업로드 성공 페이지로 리다이렉트
	         } catch (Exception e) {
	             e.printStackTrace();
	             return "error"; // 오류 페이지로 리다이렉트
	         }
	    }
	    
	
}
