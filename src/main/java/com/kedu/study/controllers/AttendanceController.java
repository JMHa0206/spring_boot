package com.kedu.study.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.ActivityDTO;
import com.kedu.study.dto.AttendanceDTO;
import com.kedu.study.service.AttendanceService;
import com.kedu.study.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
// 조휘영
@RestController
@RequestMapping("/work")
public class AttendanceController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AttendanceService AServ;
	
	@GetMapping("/checkInTime")
	public ResponseEntity<Map<String, Timestamp>> getTodayCheckInTime(HttpServletRequest request) {
	    String userId = (String) request.getAttribute("userId");
	    System.out.println(userId+": userID 오냐?");
	    Timestamp checkInTime = AServ.getTodayCheckIn(userId);
	    Timestamp checkOutTime = AServ.getTodayCheckOut(userId); // 새로 추가 필요

	    Map<String, Timestamp> map = new HashMap<>();
	    map.put("checkInTime", checkInTime);
	    map.put("checkOutTime", checkOutTime);

	    return ResponseEntity.ok(map);
	}


	
	
	@PostMapping("/checkIn")	//애만 insert하고 나머지 update
	public ResponseEntity<String> checkIn (
			@RequestBody AttendanceDTO attendancedto,
			HttpServletRequest request){
		
		String userId = (String)request.getAttribute("userId");
		System.out.println(userId+": userID 오냐?123");
		
		attendancedto.setEmp_loginId(userId); // 로그인 아이디
		LocalDateTime now = LocalDateTime.now().withNano(0); // 나노초 제거
		attendancedto.setRecord_date(Timestamp.valueOf(LocalDateTime.now())); //해당 날짜		관리자페이지 점검
		attendancedto.setCheck_in_time(Timestamp.valueOf(LocalDateTime.now())); // 출근한 날짜 및 시간
		
		try {
			AServ.checkIn(attendancedto);
			return ResponseEntity.ok("출근 시간이 기록되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("로그인 아이디가 없습니다.");
		}
	}
	
	@PostMapping("/checkOut")
	public ResponseEntity<String> checkOut(@RequestBody AttendanceDTO attendancedto,
			HttpServletRequest request){
		System.out.println("퇴근 요청 받은 ID: " + attendancedto.getEmp_loginId());

		String userId = (String)request.getAttribute("userId");
		System.out.println(userId + ": 퇴근처리");
		attendancedto.setEmp_loginId(userId); // 로그인 아이디
		LocalDateTime now = LocalDateTime.now().withNano(0); // 나노초 제거
		attendancedto.setRecord_date(Timestamp.valueOf(LocalDateTime.now())); //해당 날짜
		attendancedto.setCheck_out_time(Timestamp.valueOf(LocalDateTime.now())); // 출근한 날짜 및 시간
		
		try {
			AServ.checkOut(attendancedto);
			return ResponseEntity.ok("퇴근 시간이 기록되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body("로그인 아이디가 없습니다.");
		}
	}

	@PostMapping("/start")
	public ResponseEntity<String> startActivity(@RequestBody ActivityDTO dto,
	                                            HttpServletRequest request) {
	    String userId = (String) request.getAttribute("userId");

	    Integer attendanceId = AServ.findTodayAttendanceId(userId);
	    if (attendanceId == null) {
	        return ResponseEntity.status(400).body("출근 기록이 없습니다.");
	    }

	    dto.setAttendance_id(attendanceId);
	    AServ.handleActivityChange(dto);
	    return ResponseEntity.ok("활동 전환 완료");

	}


}
