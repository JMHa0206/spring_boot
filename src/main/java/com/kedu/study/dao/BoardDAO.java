package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.BoardDTO;
import com.kedu.study.dto.ContactsDTO;

@Repository
public class BoardDAO {
	@Autowired
	public SqlSession mybatis;
	
	public List<ContactsDTO> selectAll(){
		System.out.println("3");
		return mybatis.selectList("Contacts.selectAll");
	};
	
	public int insert(ContactsDTO dto) {
		return mybatis.insert("Contacts.insertContact",dto);
		
	}
	//아이디로 삭제
	public int delete(int id) {
		return mybatis.delete("Contacts.deleteContact",id);
	}
}
