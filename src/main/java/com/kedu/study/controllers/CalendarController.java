package com.kedu.study.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.kedu.study.dto.CalendarDTO;
import com.kedu.study.dto.CalendarShareDTO;
import com.kedu.study.service.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
@Autowired
	private CalendarService cServ;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> calender(@RequestBody CalendarDTO calender){
		cServ.inputCalender(calender);
		 Map<String, Object> response = new HashMap<>();
		 response.put("c_id", calender.getC_id());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/calendarShare")
	public ResponseEntity<?> caledarShare(@RequestBody List<CalendarShareDTO> target){
		cServ.caledarShare(target);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CalendarDTO>> selectAllList(){
		List<CalendarDTO> list =cServ.selectAllList();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/sharedList/{emp_code_id}")
	public ResponseEntity<List<CalendarDTO>> sharedList(@PathVariable int emp_code_id){
		System.out.println("공유캘린더 사원 코드 : " + emp_code_id);
		List<CalendarDTO> sharedList = cServ.sharedList(emp_code_id);
		return ResponseEntity.ok(sharedList);
	}
	
	@GetMapping("/myCal/{emp_code_id}")
	public ResponseEntity<List<CalendarDTO>> myCalendar(@PathVariable int emp_code_id){
		List<CalendarDTO> myCalList = cServ.selectMyCal(emp_code_id);
		return ResponseEntity.ok(myCalList);
	}
	

	@GetMapping("/comCal/{emp_code_id}")
	public ResponseEntity<List<CalendarDTO>> companyCalendar(@PathVariable int emp_code_id){
		List<CalendarDTO> companyCalendar = cServ.selectComCal(emp_code_id);
		return ResponseEntity.ok(companyCalendar);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCalendar(@PathVariable int id){
		cServ.deleteCalendar(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCalendar(@RequestBody CalendarDTO calendar){
		cServ.updateCalendar(calendar);
		return ResponseEntity.ok().build();
	}
	
	
}


