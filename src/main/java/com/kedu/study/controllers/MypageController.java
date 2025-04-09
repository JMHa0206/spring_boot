package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.service.MypageService;

import jakarta.servlet.http.HttpServletRequest;
// 조휘영
@RestController
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService MyServ;
	
	
	@GetMapping("/info")
	public ResponseEntity <EmployeeDTO> userinfo(HttpServletRequest request){
		String userId = (String) request.getAttribute("userId");
	    EmployeeDTO employee = MyServ.userinfo(userId);
	    return ResponseEntity.ok(employee);
	}
	@PutMapping("/update")
	public ResponseEntity <String> userupdate(HttpServletRequest request, @RequestBody EmployeeDTO Empdto){
		String userId = (String) request.getAttribute("userId");
		Empdto.setEmp_loginId(userId);
		int result = MyServ.userupdate(Empdto);
		if(result>0) {
			return ResponseEntity.ok("정보가 성공적으로 수정되었습니다.");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수정 실패");
		}
		
	}

}
