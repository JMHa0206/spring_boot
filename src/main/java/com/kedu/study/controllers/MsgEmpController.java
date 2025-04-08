package com.kedu.study.controllers;

import java.util.HashMap;
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

import com.kedu.study.dto.ChatRoomDTO;
import com.kedu.study.dto.MessageDTO;
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
	public ResponseEntity<Map<String,Object>> madeChatRoom(@RequestBody Map<String,Object> names){
		eServ.madeChatRoom(names);
		Integer seq = (Integer) names.get("seq");
		Map<String,Object> response = new HashMap<>();
		response.put("seq", seq);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/checkRoomExist")
	public ResponseEntity<Boolean> checkRoomExist(
	    @RequestParam String targetname,
	    @RequestParam String myname) {
		
	    boolean exists = eServ.checkRoomExist(targetname, myname);
	    return ResponseEntity.ok(exists);  // true 또는 false 반환
	}
	
	@GetMapping("/checkRoomSeqExist")
	public ResponseEntity<Map<String,Object>> checkRoomSeqExist(@RequestParam int targetId,
			@RequestParam int myId){
			System.out.println(targetId+ " : "+myId);
			Map<String,Object> seq = eServ.checkRoomSeqExist(targetId,myId);
		return ResponseEntity.ok(seq);
	}
	
	@GetMapping("/showMessages")
	public ResponseEntity<List<MessageDTO>> showMessages(@RequestParam int seq){
			System.out.println(seq);
			List<MessageDTO> list = eServ.showMessages(seq);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/selectMyId")
	public ResponseEntity<Integer> selectMyId(@RequestParam String userId){
		int id = eServ.selectMyId(userId);
		return ResponseEntity.ok(id);
	}
	
	@GetMapping("/selectRoom")
	public ResponseEntity<List<Map<String,Object>>> selectRoom(@RequestParam int myId){
		List<Map<String,Object>> list = eServ.selectRoom(myId);
		return ResponseEntity.ok(list);
	}
	
}
