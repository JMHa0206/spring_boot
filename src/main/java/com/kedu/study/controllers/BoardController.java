package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.BoardDTO;

import com.kedu.study.service.BoardService;


@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	//getmapping은 가져오는것
	@GetMapping
	public ResponseEntity<List<BoardDTO>> select() {
//		System.out.println("1");
//		List<BoardDTO> list = boardService.selectAll();
//		System.out.println("4");
//		return ResponseEntity.ok(list);
		return null;
	}

	//ok에 돌려받는 데이터가 없기 때문에 void를 씀
	//postmapping은 생성하는 것 
	//insert부분
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody BoardDTO board) {
		System.out.println(board.getBoard_title()+ " : " +board.getBoard_content());
		boardService.write(board);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	//아이디로 삭제
	//delete 부분
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		boardService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
