package com.kedu.study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*") 
//@CrossOrigin(origins = "http://10.5.5.6:3000") 
public class BoardController {

	 @Autowired
	    private BoardService boardService;

	    @GetMapping("/list")
	    public List<BoardDTO> getBoardList() {
	    	System.out.println("4");
	        return boardService.getBoardList();
	    }
}
