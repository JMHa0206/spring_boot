package com.kedu.study.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.dto.ProfileImgDTO;
import com.kedu.study.service.MypageService;

import jakarta.servlet.http.HttpServletRequest;

// 조휘영
@RestController
@RequestMapping("/mypage")
public class MypageController {

	@Autowired
	private MypageService MyServ;

	@GetMapping("/info")
	public ResponseEntity<EmployeeDTO> userinfo(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId");
		EmployeeDTO employee = MyServ.userinfo(userId);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/update")
	public ResponseEntity<String> userupdate(
			@RequestPart("data") EmployeeDTO Empdto,
		    @RequestPart(value = "profile", required = false) MultipartFile profileFile,
		    HttpServletRequest request) {

	    String userId = (String) request.getAttribute("userId");
	    Empdto.setEmp_loginId(userId);

	    // 프로필 이미지 저장
	    if (profileFile != null && !profileFile.isEmpty()) {
	        String filePath = saveFile(profileFile);
	        ProfileImgDTO profileDTO = new ProfileImgDTO();
	        profileDTO.setProfile_emp_id(Empdto.getEmp_code_id()); 
	        profileDTO.setProfile_path(filePath);
	        Empdto.setProfileDTO(profileDTO);
	        MyServ.saveProfile(profileDTO);
	    }

	    int result = MyServ.userupdate(Empdto);
	    return result > 0
	            ? ResponseEntity.ok("정보 수정 완료")
	            : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수정 실패");
	}

	private String saveFile(MultipartFile file) {
	    try {
	    	String uploadDir = "C:/files/upload/profile"; // 실서버 환경에 맞게 수정
	    	System.out.println(uploadDir+": uploadDir");
	        File dir = new File(uploadDir);
	        if (!dir.exists()) dir.mkdirs();

	        String filePath = uploadDir + "/" + file.getOriginalFilename();
	        System.out.println(filePath+": filePath");
	        file.transferTo(new File(filePath));

	        return "/files/upload/profile/" + file.getOriginalFilename(); // DB에 저장될 경로
	    } catch (IOException e) {
	        throw new RuntimeException("파일 저장 실패", e);
	    }
	}



}
