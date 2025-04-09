package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MypageDAO;

@Service
public class MypageService {
	
	@Autowired
	private MypageDAO MyDao;
	
}
