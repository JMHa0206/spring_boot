package com.kedu.study.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ScheduleCategoryDTO;


@Repository
public class ScheduleCategoryDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public void inputCalender(ScheduleCategoryDTO calender) {
		mybatis.insert("schedule.inputCalender", calender);
	}

}
