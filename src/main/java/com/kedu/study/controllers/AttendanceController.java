package com.kedu.study.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ActivityDTO;
import com.kedu.study.dto.AttendanceDTO;
import com.kedu.study.service.AttendanceService;
import com.kedu.study.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("work")
public class AttendanceController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AttendanceService AServ;
	
	
	@PostMapping("/checkIn")	//애만 insert하고 나머지 update
	public ResponseEntity<String> checkIn (
			@RequestBody AttendanceDTO attendancedto,
			HttpServletRequest request){
		
		String userId = (String)request.getAttribute("userId");
		System.out.println(userId+" : userId");
		
		attendancedto.setEmp_loginId(userId); // 로그인 아이디
		attendancedto.setRecord_date(Timestamp.valueOf(LocalDateTime.now())); //해당 날짜
		attendancedto.setCheck_in_time(Timestamp.valueOf(LocalDateTime.now())); // 출근한 날짜 및 시간
		
		try {
			AServ.checkIn(attendancedto);
			return ResponseEntity.ok("출근 시간이 기록되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("로그인 아이디가 없습니다.");
		}
	}

}

//	@PostMapping("/checkOut")
//	
//	@PostMapping("/work")
//	
//	@PostMapping("/outing")
	










//	
//	@PostMapping("/checkIn")
//	public String checkIn(@RequestBody ScheduleDTO checkInRequest) {		// insert 하고 나머지는 다 update로 하면됨
//		
//		LocalDateTime checkInTime = LocalDateTime.now();
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		String formattedTime = checkInTime.format(formatter);
//
//		System.out.println("출근 시간: " + formattedTime);
//
//		return "출근 시간을 기록했습니다: " + formattedTime;
//	}
//
//	@PostMapping("/checkOut")
//	public String checkOut(@RequestBody ScheduleDTO checkOutRequest) {
//
//		LocalDateTime checkOutTime = LocalDateTime.now();
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		String formattedTime = checkOutTime.format(formatter);
//
//		System.out.println("퇴근 시간: " + formattedTime);
//
//		return "퇴근 시간을 기록했습니다: " + formattedTime;
//	}
//
//	@PostMapping("/work")
//	public String work(@RequestBody ScheduleDTO workRequest) {
//
//		LocalDateTime workTime = LocalDateTime.now();
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		String formattedTime = workTime.format(formatter);
//
//		System.out.println("업무 시간: " + formattedTime);
//
//		return "업무 시간을 기록했습니다: " + formattedTime;
//	}
//
//	@PostMapping("/outing")
//	public String outing(@RequestBody ScheduleDTO outingRequest) {
//
//		LocalDateTime outingTime = LocalDateTime.now();
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//		String formattedTime = outingTime.format(formatter);
//
//		System.out.println("외근 시간: " + formattedTime);
//
//		return "외근 시간을 기록했습니다: " + formattedTime;
//	}


