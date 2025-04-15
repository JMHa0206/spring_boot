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
	
	public List<CalendarDTO> sharedList(int emp_code_id){
		return cDao.sharedList(emp_code_id);
	}
	
	public List<CalendarDTO> selectMyCal(int emp_code_id){
		return cDao.selectMyCal(emp_code_id);
	}
	
	public List<CalendarDTO> selectComCal(int emp_code_id){
		return cDao.selectComCal(emp_code_id);
	}
	
	public void caledarShare(List<CalendarShareDTO> calendarShare) {
		for (CalendarShareDTO share : calendarShare) {
	        cDao.caledarShare(share);
	    }
	}
	
	public void deleteCalendar(int id) {
		cDao.deleteCalendar(id);
	}
	

}
