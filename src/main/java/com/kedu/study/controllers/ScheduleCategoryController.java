package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ScheduleCategoryDTO;
import com.kedu.study.service.ScheduleCategoryService;


@RestController
@RequestMapping("/cSchedule")
public class ScheduleCategoryController {
	
	@Autowired
	private ScheduleCategoryService sCServ;
	
	@PostMapping
	public ResponseEntity<List<ScheduleCategoryDTO>> calender(@RequestBody ScheduleCategoryDTO calender){
		System.out.println("요청 도착" + calender);
		sCServ.inputCalender(calender);
		return ResponseEntity.ok().build();
	}
	
	
}
