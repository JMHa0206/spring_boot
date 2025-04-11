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
	    
	    //insert 부분
	    public void insertBoard(BoardDTO post) {
	    	bdao.insertBoard(post);
	    }
	    
	    //board_id로 제목이랑 내용불러오는 부분
	    public BoardDTO getBoardById(int post_id) {
	    	return bdao.findBoardid(post_id);
	    }

	    //수정부분
	    public void updateBoard(BoardDTO post) {
	    	bdao.updateBoard(post);
	    }
	    
	    //삭제부분
	    public void deleteBoard(int post_id) {
	    	bdao.deleteBoard(post_id);
	    }
	    
	 // 조회수 증가
	    public void increaseViewCount(int post_id) {
	        bdao.increaseViewCount(post_id);  // BoardDAO의 increaseViewCount 메서드 호출
	    }
	    
	    //추천수 증가
	    public void increaseLikeCount(int post_id) {
	    	bdao.increaseLikeCount(post_id);
	    }
}