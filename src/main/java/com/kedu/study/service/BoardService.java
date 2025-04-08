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
	  
	  	//테이블 전체를 불러오는 부분
	    public List<BoardDTO> selectAll() {
	    	List<BoardDTO> list = bdao.selectAll();
	        return list;
	    }
	    
	    //board_id로 제목이랑 내용불러오는 부분
	    public BoardDTO getBoardById(int board_id) {
	   	  System.out.println("2"); 
	    	return bdao.findBoardid(board_id);
	    }

	    //수정부분
	    public void updateBoard(BoardDTO board) {
	    	bdao.updateBoard(board);
	    }
	    
	    //삭제부분
	    public void deleteBoard(int board_id) {
	    	bdao.deleteBoard(board_id);
	    }
	    
}