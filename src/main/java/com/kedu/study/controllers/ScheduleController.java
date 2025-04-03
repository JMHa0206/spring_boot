package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
