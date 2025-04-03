package com.kedu.study.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ScheduleDTO;

@Repository
public class ScheduleDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public void inputEvent(ScheduleDTO event){
		mybatis.insert("schedule.inputEvent", event);
	}

}
