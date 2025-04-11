package com.kedu.study.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.dto.BoardFileDTO;



@Repository
public class BoardFileDAO {
	@Autowired
	public SqlSession fmybatis;
	
	public int insertBoardFile(BoardFileDTO boardFileDTO) {
		return fmybatis.insert("board.insertBoardFile",boardFileDTO);
	}
}
