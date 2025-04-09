package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.BoardDTO;



@Repository
public class BoardDAO {
	@Autowired
	public SqlSession mybatis;
	
	//테이블 전체를 불러오는 부분
	public List<BoardDTO> selectAll(){
		return mybatis.selectList("board.selectAll");
		
	};
	
	 //board_id로 제목이랑 내용불러오는 부분
	public BoardDTO findBoardid(int board_id) {
		return mybatis.selectOne("board.findBoardid",board_id);
	};
	
	//수정부분
	public void updateBoard(BoardDTO board) {
	    mybatis.update("board.updateBoard", board);
	}

	//삭제부분
	public void deleteBoard(int board_id) {
		mybatis.delete("board.deleteBoard",board_id);
	}
}
