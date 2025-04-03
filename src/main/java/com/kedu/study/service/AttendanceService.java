package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.AttendanceDAO;
import com.kedu.study.dto.AttendanceDTO;

@Service
public class AttendanceService {
	
	
	@Autowired
	private AttendanceDAO ADao;
	
	public int checkIn(AttendanceDTO attendancedto) {
		return ADao.checkIn(attendancedto);
	}

}
