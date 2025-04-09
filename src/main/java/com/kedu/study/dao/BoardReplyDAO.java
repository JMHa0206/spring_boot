package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.kedu.study.dto.BoardReplyDTO;

@Repository
public class BoardReplyDAO {
	@Autowired
	public SqlSession rmybatis;
	
	//테이블 전체를 불러오는 부분
	public List<BoardReplyDTO> selectAll(int board_id){
		return rmybatis.selectList("reply.selectAll",board_id);
		
	};
	
	//insert 부분
	public int insertReply(BoardReplyDTO reply) {
		return rmybatis.insert("reply.insertReply",reply);
	}
	
	 //board_id로 제목이랑 내용불러오는 부분
	public BoardReplyDTO findReplyid(int reply_id) {
		return rmybatis.selectOne("reply.findReplyid",reply_id);
	};
	
	//수정부분
	public void updateReply(BoardReplyDTO reply) {
	    rmybatis.update("reply.updateReply", reply);
	}

	//삭제부분
	public void deleteReply(int reply_id) {
		rmybatis.delete("reply.deleteReply",reply_id);
	}
}
