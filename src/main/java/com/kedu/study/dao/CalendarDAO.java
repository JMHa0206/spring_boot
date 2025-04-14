package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.CalendarDTO;
import com.kedu.study.dto.CalendarShareDTO;

@Repository
public class CalendarDAO {
	@Autowired
	private SqlSession mybatis;
	
	public void inputCalendar(CalendarDTO calendar) {
		mybatis.insert("calendar.inputCalendar", calendar);
	}
	
	public List<CalendarDTO> selectAllList(){
		return mybatis.selectList("calendar.selectAllList");
	}
	
	public List<CalendarDTO> sharedList(int emp_code_id){
		return mybatis.selectList("calendar.sharedList", emp_code_id);
	}
	
	public List<CalendarDTO> selectMyCal(int emp_code_id){
		return mybatis.selectList("calendar.selectMyCal", emp_code_id);
	}
	
	public List<CalendarDTO> selectComCal(int emp_code_id){
		return mybatis.selectList("calendar.selectComCal", emp_code_id);
	}
	
	public void caledarShare(CalendarShareDTO calendarShare) {
		mybatis.update("calendar.calendarShare", calendarShare);
	}


}
