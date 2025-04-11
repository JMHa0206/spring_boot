package com.kedu.study.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.CalendarDTO;
import com.kedu.study.dto.CalendarShareDTO;
import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.service.CalendarService;

import jakarta.servlet.http.HttpServletRequest;

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
	
	@GetMapping("/sharedList")
	public ResponseEntity<List<Integer>> sharedList(HttpServletRequest request){
		String userId = (String) request.getAttribute("userId");
		List<Integer> sharedList = cServ.sharedList(userId);
		return ResponseEntity.ok(sharedList);
	}
	
	@GetMapping("/myCal")
	public ResponseEntity<List<CalendarDTO>> myCalendar(@RequestParam("public_code") int publicCode){
		List<CalendarDTO> myCalList = cServ.selectMyCal(publicCode);
		return ResponseEntity.ok(myCalList);
	}
	
	@GetMapping("/publicCal")
	public ResponseEntity<List<CalendarDTO>> publicCalendar(@RequestParam("public_code") int publicCode){
		List<CalendarDTO> publicCalList = cServ.selectMyCal(publicCode);
		return ResponseEntity.ok(publicCalList);
	}
	
	@GetMapping("/comCal")
	public ResponseEntity<List<CalendarDTO>> companyCalendar(@RequestParam("public_code") int publicCode){
		List<CalendarDTO> companyCalendar = cServ.selectMyCal(publicCode);
		return ResponseEntity.ok(companyCalendar);
	}
	
	
}


