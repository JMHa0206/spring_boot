package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ScheduleDTO;
import com.kedu.study.service.ScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService sServ;
	
	@PostMapping
	public ResponseEntity<List<ScheduleDTO>> inputEvent(@RequestBody ScheduleDTO event){
		System.out.println(event.getCategory_id() + " : " + event.getId() + " : " + event.getTitle() + " : " + event.getContent());;
		sServ.inputEvent(event);
		return ResponseEntity.ok().build();
	}
	
	
}
