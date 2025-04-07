package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ScheduleCategoryDTO;
import com.kedu.study.dto.ScheduleDTO;
import com.kedu.study.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService sServ;
	
	@PostMapping
	public ResponseEntity<List<ScheduleDTO>> inputEvent(@RequestBody ScheduleDTO event){
		sServ.inputEvent(event);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ScheduleDTO>> getAllEvents(){
		List<ScheduleDTO> events = sServ.getAllEvents();
		System.out.println(events.get(0).getTitle() + " : " + events.get(1).getTitle() + " : " +events.get(2).getTitle());
		return  ResponseEntity.ok(events);
	}

	
	
}
