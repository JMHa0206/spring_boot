package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.CalendarDTO;

@Repository
public class CalendarDAO {
	@Autowired
	private SqlSession mybatis;
	
	public void inputCalender(CalendarDTO calender) {
		mybatis.insert("calender.inputCalender", calender);
	}
	
	public List<CalendarDTO> selectAllList(){
		return mybatis.selectList("calender.selectAllList");
	}


}
