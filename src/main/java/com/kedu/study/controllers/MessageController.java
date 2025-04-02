package com.kedu.study.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.service.BoardService;

@Controller
public class MessageController {
	@Autowired private BoardService bServ;
	
	public String a() {
		List<BoardDTO> a = new ArrayList<>();
				bServ.selectAll();
		List<BoardDTO> b = new LinkedList<>();
		
		return "";
	}
}
