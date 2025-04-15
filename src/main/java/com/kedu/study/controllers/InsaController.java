package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.AdminSummaryDTO;
import com.kedu.study.dto.DepartmentAttendanceDTO;
import com.kedu.study.dto.Departsimple;
import com.kedu.study.dto.OvertimeDTO;
import com.kedu.study.dto.WorkSummaryDTO;
import com.kedu.study.service.InsaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/insa")
public class InsaController {

	@Autowired
	private InsaService IServ;

	//근태관리
	@GetMapping("/summary")
	public ResponseEntity<WorkSummaryDTO> getSummary(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId"); // JwtFilter에서 주입
		WorkSummaryDTO summary = IServ.getWeeklySummary(userId);
		return ResponseEntity.ok(summary);
	}
	// 휴가 출장 기록관리
	@GetMapping("/admin-summary")
	public ResponseEntity<AdminSummaryDTO> getAdminSummary() {
	    AdminSummaryDTO summary = IServ.getAdminSummary();
	    return ResponseEntity.ok(summary);
	}
	// 휴가 출장 기록관리 에서 초과근무 출력
	@GetMapping("/overtime")
	public ResponseEntity<List<OvertimeDTO>>overtime(){
		List<OvertimeDTO> list = IServ.getMonthlyOvertimeList();
        return ResponseEntity.ok(list);
	}
	
	// 부서별 출/퇴근 및 근무 기록 에서 부서 선택
	@GetMapping("/departments")
	public ResponseEntity<List<Departsimple>> getAllDepartments() {
	    List<Departsimple> departments = IServ.getAllDepartments();
	    return ResponseEntity.ok(departments);
	}
	
	// 부서별 출퇴근 기록
	@GetMapping("/by-department")
	public ResponseEntity<List<DepartmentAttendanceDTO>> getDepartments(@RequestParam("deptId") int deptId,
		    @RequestParam("page") int page,
		    @RequestParam("size") int size){
		System.out.println("1");
		List<DepartmentAttendanceDTO> list = IServ.getDepartments(deptId, page, size);
		System.out.println("2");
		return ResponseEntity.ok(list);
	}
}