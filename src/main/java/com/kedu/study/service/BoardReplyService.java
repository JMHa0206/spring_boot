package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.BoardReplyDAO;

import com.kedu.study.dto.BoardReplyDTO;

@Service
public class BoardReplyService {
	@Autowired
    public BoardReplyDAO brdao;
  
  	//테이블 전체를 불러오는 부분
    public List<BoardReplyDTO> selectAll(int board_id) {
    	List<BoardReplyDTO> list = brdao.selectAll(board_id);
        return list;
    }
    
    //insert 부분
    public void insertReply(BoardReplyDTO reply) {
    	brdao.insertReply(reply);
    }
    
    //board_id로 제목이랑 내용불러오는 부분
    public BoardReplyDTO getReplyById(int reply_id) {
    	return brdao.findReplyid(reply_id);
    }

    //수정부분
    public void updateReply(BoardReplyDTO reply) {
    	brdao.updateReply(reply);
    }
    
    //삭제부분
    public void deleteReply(int reply_id) {
    	brdao.deleteReply(reply_id);
    }
}
