package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MessageDAO;
import com.kedu.study.dto.MessageDTO;

@Service
public class MessageService {
	
	@Autowired
	private MessageDAO mDao;
	
	public void saveMessage(MessageDTO message) {
		 mDao.saveMessage(message);
	}
	
}
