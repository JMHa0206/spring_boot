package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kedu.study.dto.BoardReplyDTO;
import com.kedu.study.service.BoardReplyService;


@RestController
@RequestMapping("/reply")
public class BoardReplyController {
	@Autowired
    private BoardReplyService replyService;

 	
 	//테이블 전체를 불러오는 부분
    @GetMapping
    public ResponseEntity<List<BoardReplyDTO>> getReplyList(@RequestParam int board_id) {
    	List<BoardReplyDTO> list= replyService.selectAll(board_id);
        return ResponseEntity.ok(list);
    }
    
    //insert부분
    @PostMapping("/insert")
	public ResponseEntity<Void> insertReply(@RequestBody BoardReplyDTO reply) {
		replyService.insertReply(reply);
		return ResponseEntity.ok().build();
	}
    
    
    
    //board_id로 제목이랑 내용불러오는 부분
    @GetMapping("/{reply_id}")
    public ResponseEntity<BoardReplyDTO> getReplyById(@PathVariable int reply_id) {
    	BoardReplyDTO rlist = replyService.getReplyById(reply_id);
    	return ResponseEntity.ok(rlist);
    		
    }
    
    //수정부분
    @PutMapping("/update")
    public ResponseEntity<Void> updateReply(@RequestBody BoardReplyDTO reply) {
        replyService.updateReply(reply); // Service 호출
        return ResponseEntity.ok().build(); // 성공 응답
    }
    
    //삭제부분
    @DeleteMapping("/{reply_id}")
    public ResponseEntity<Void> deleteReply(@PathVariable int reply_id){
    	replyService.deleteReply(reply_id);
    	return ResponseEntity.ok().build();
    }
    
}
