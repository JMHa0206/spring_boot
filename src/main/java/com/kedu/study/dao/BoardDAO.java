package com.kedu.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.dto.BoardlistwriterDTO;



@Repository
public class BoardDAO {
	@Autowired
	public SqlSession mybatis;
	
	//테이블 전체를 불러오는 부분
	public List<BoardDTO> selectAll(){
		return mybatis.selectList("board.selectAll");
		
	};
	
	//insert 부분
	public int insertBoard(BoardDTO post) {
		return mybatis.insert("board.insertBoard",post);
	}
	
	 //board_id로 제목이랑 내용불러오는 부분
	public BoardDTO findBoardid(int post_id) {
		return mybatis.selectOne("board.findBoardid",post_id);
	};
	
	//수정부분
	public void updateBoard(BoardDTO post) {
	    mybatis.update("board.updateBoard", post);
	}

	//삭제부분
	public void deleteBoard(int post_id) {
		mybatis.delete("board.deleteBoard",post_id);
	}
	
    //제목으로 게시글 개수 세기
    public int increaseViewCount(int post_id) {
        return mybatis.update("board.increaseViewCount", post_id);  
    }
    
    //추천수 증가 부분
    public int increaseLikeCount(int post_id) {
        return mybatis.update("board.increaseLikeCount", post_id); 
    }
    
    // 게시글 목록 조회
    public List<BoardDTO> selectBoardList(Map<String, Object> paramMap) {
        return mybatis.selectList("board.selectBoardList", paramMap);
    }

    // 게시글 개수 조회
    public int countBoard(int parentBoard) {
        return mybatis.selectOne("board.countBoard", parentBoard);
    }
    
  
}
