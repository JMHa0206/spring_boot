package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.CalendarDAO;
import com.kedu.study.dto.CalendarDTO;
import com.kedu.study.dto.CalendarShareDTO;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarDAO cDao;
	
	public void inputCalender(CalendarDTO calender) {
		cDao.inputCalendar(calender);
	}
	
	public List<CalendarDTO> selectAllList() {
		return cDao.selectAllList();
	}
	
	public List<Integer> sharedList(String userId){
		return cDao.sharedList(userId);
	}
	
	public List<CalendarDTO> selectMyCal(int publicCode){
		return cDao.selectMyCal(publicCode);
	}
	public void caledarShare(List<CalendarShareDTO> calendarShare) {
		for (CalendarShareDTO share : calendarShare) {
	        cDao.caledarShare(share);
	    }
//		cDao.caledarShare(calendarShare);
	}

}
