package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.study.dto.ChattingRoomDTO;
import com.kedu.study.dto.MsgEmpDTO;
import com.kedu.study.service.MsgEmpService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Employee")
public class MsgEmpController {
	
	@Autowired
	private MsgEmpService eServ;
	
	@GetMapping("/SelectEmp")
	public ResponseEntity<List<MsgEmpDTO>> select(){
		List<MsgEmpDTO> list = eServ.select();

		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/SelectGroupId")
	public ResponseEntity<List<ChattingRoomDTO>> selectGroupId() {
		List<ChattingRoomDTO> list= eServ.selectGroupId();
		return ResponseEntity.ok(list);
	}
	
}
