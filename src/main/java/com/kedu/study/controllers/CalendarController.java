package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.CalendarDTO;
import com.kedu.study.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
@Autowired
	private CalendarService cServ;
	
	@PostMapping
	public ResponseEntity<List<CalendarDTO>> calender(@RequestBody CalendarDTO calender){
		cServ.inputCalender(calender);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CalendarDTO>> selectAllList(){
		List<CalendarDTO> list =cServ.selectAllList();
		return ResponseEntity.ok(list);
	}
}


