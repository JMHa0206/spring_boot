package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		System.out.println(event.getId() + " : " + event.getC_id() + " : " + event.getEmp_id() + " : " + event.getTitle() + " : " + event.getContent() + " : " + event.getStart_date() + " : " + event.getEnd_date() + " : " + event.getStartTime() + " : " + event.getEndTime());
		sServ.inputEvent(event);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/comEvents")
	public ResponseEntity<List<ScheduleDTO>> getComEvents(){
		List<ScheduleDTO> events = sServ.getComEvents();
		return  ResponseEntity.ok(events);
	}
	
	@GetMapping("/myEvents/{emp_code_id}")
	public ResponseEntity<List<ScheduleDTO>> getMyEvents(@PathVariable String emp_code_id){
		List<ScheduleDTO> events = sServ.getMyEvents(emp_code_id);
		return  ResponseEntity.ok(events);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ScheduleDTO> selectEvent(@PathVariable int id) {
		ScheduleDTO event = sServ.selectEvent(id);
		return ResponseEntity.ok(event);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		sServ.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateById(@PathVariable int id, @RequestBody ScheduleDTO evnet){
		System.out.println("Controller");
		sServ.updateById(id, evnet);
		return ResponseEntity.ok().build();
	}
	
}
