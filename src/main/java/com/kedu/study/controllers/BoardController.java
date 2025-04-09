package com.kedu.study.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kedu.study.controllers.EDMS.EDMSCategoryController;
import com.kedu.study.dto.BoardDTO;

import com.kedu.study.service.BoardService;


@RestController
@RequestMapping("/board")
public class BoardController {

	 	@Autowired
	    private BoardService boardService;

	 	
	 	//테이블 전체를 불러오는 부분
	    @GetMapping
	    public ResponseEntity<List<BoardDTO>> getBoardList() {
	    	List<BoardDTO> list= boardService.selectAll();
	        return ResponseEntity.ok(list);
	    }
	    
	    //board_id로 제목이랑 내용불러오는 부분
	    @GetMapping("/{board_id}")
	    public ResponseEntity<BoardDTO> getBoardById(@PathVariable int board_id) {
	    	BoardDTO blist = boardService.getBoardById(board_id);
	    	return ResponseEntity.ok(blist);
	    		
	    }
	    
	    //수정부분
	    @PutMapping("/update")
	    public ResponseEntity<Void> updateBoard(@RequestBody BoardDTO board) {
	        boardService.updateBoard(board); // Service 호출
	        return ResponseEntity.ok().build(); // 성공 응답
	    }
	    
	    //삭제부분
	    @DeleteMapping("/{board_id}")
	    public ResponseEntity<Void> deleteBoard(@PathVariable int board_id){
	    	boardService.deleteBoard(board_id);
	    	return ResponseEntity.ok().build();
	    }
	    
}


