package com.kedu.study.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kedu.study.dto.MsgEmpDTO;
import com.kedu.study.dto.MsgEmpMineDTO;
import com.kedu.study.service.MsgEmpService;

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
	
	@GetMapping("/SelectMine")
	public ResponseEntity<MsgEmpMineDTO> selectMine(@RequestParam String userId) {
		System.out.println(userId);
		MsgEmpMineDTO result = eServ.selectMine(userId);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/madeChatRoom")
	public ResponseEntity<Void> madeChatRoom(@RequestBody Map<String,String> names){
		
		eServ.madeChatRoom(names);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/checkRoomExist")
	public ResponseEntity<Boolean> checkRoomExist(
	    @RequestParam String targetname,
	    @RequestParam String myname) {
		
	    boolean exists = eServ.checkRoomExist(targetname, myname);
	    return ResponseEntity.ok(exists);  // true 또는 false 반환
	}
	
}
