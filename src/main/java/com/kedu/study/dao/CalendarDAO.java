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
//		mybatis.insert("calendar.calendarShare)",calendar);
	}
	
	public List<CalendarDTO> selectAllList(){
		return mybatis.selectList("calendar.selectAllList");
	}
	
	public List<CalendarDTO> selectMyCal(int publicCode){
		return mybatis.selectList("calendar.selectMyCal", publicCode);
	}
	
	public void caledarShare(List<CalendarShareDTO> calendarShare) {
		mybatis.update("calendar.updateCalShare", calendarShare);
	}


}
