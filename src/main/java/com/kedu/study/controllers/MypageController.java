package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.service.MypageService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService MyServ;
	
	
	@GetMapping("/info")
	public ResponseEntity <EmployeeDTO> userinfo(HttpServletRequest request){
		String userId = (String) request.getAttribute("userId");
	    EmployeeDTO employee = MyServ.userinfo(userId);
	    System.out.println("직급 이름: " + employee.getJobDTO().getJob_name());
	    System.out.println("직급 아이디 : "+employee.getJobDTO().getJob_id());

	    System.out.println("jobDTO null? " + (employee.getJobDTO() == null));


	    return ResponseEntity.ok(employee);
	}
}
