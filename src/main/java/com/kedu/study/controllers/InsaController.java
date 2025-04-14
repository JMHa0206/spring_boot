package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.AdminSummaryDTO;
import com.kedu.study.dto.WorkSummaryDTO;
import com.kedu.study.service.InsaService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/insa")
public class InsaController {

	@Autowired
	private InsaService IServ;

	@GetMapping("/summary")
	public ResponseEntity<WorkSummaryDTO> getSummary(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId"); // JwtFilter에서 주입
		System.out.println(userId + ": userID 오냐??");
		WorkSummaryDTO summary = IServ.getWeeklySummary(userId);
		return ResponseEntity.ok(summary);
	}
	@GetMapping("/admin-summary")
	public ResponseEntity<AdminSummaryDTO> getAdminSummary() {
	    AdminSummaryDTO summary = IServ.getAdminSummary();
	    return ResponseEntity.ok(summary);
	}
}