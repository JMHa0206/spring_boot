package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.CalendarDAO;
import com.kedu.study.dto.CalendarDTO;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarDAO cDao;
	
	public void inputCalender(CalendarDTO calender) {
		cDao.inputCalender(calender);
	}
	
	public List<CalendarDTO> selectAllList() {
		return cDao.selectAllList();
	}

}
