package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.study.dto.MsgEmpDTO;
import com.kedu.study.service.MsgEmpService;

@Controller
@RequestMapping("/Employee")
public class MsgEmpController {
	
	@Autowired
	private MsgEmpService eServ;
	
	@GetMapping
	public ResponseEntity<List<MsgEmpDTO>> select(){
		List<MsgEmpDTO> list = eServ.select();

		return ResponseEntity.ok(list);
	}
	
	
}
