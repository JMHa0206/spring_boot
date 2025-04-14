package com.kedu.study.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.MessageDTO;

@Repository
public class MessageDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public void saveMessage(MessageDTO message) {
		mybatis.insert("Message.saveMessage",message);
	}
	
	
}
