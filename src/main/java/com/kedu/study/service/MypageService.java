package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MypageDAO;
import com.kedu.study.dto.EmployeeDTO;

@Service
public class MypageService {
	
	@Autowired
	private MypageDAO MyDao;
	
	public EmployeeDTO userinfo(String userId) {
		return MyDao.userinfo(userId);
	}
	
}
