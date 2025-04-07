package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.ScheduleCategoryDAO;
import com.kedu.study.dto.ScheduleCategoryDTO;

@Service
public class ScheduleCategoryService {

	@Autowired
	private ScheduleCategoryDAO sCDao;
	
	public void inputCalender(ScheduleCategoryDTO calender) {
		sCDao.inputCalender(calender);
	}
}
