package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.service.MypageService;

@RestController
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private MypageService MyServ;
	
	

}
