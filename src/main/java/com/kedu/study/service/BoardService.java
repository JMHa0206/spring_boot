package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.BoardDAO;
import com.kedu.study.dto.BoardDTO;
@Service
public class BoardService {
	
	  @Autowired
	    public BoardDAO bdao;

	    public List<BoardDTO> getBoardList() {
	    	  System.out.println("2"); 
	        return bdao.selectAll();
	    }
}
