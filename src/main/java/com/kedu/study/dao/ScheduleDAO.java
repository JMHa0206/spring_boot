package com.kedu.study.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ScheduleCategoryDTO;
import com.kedu.study.dto.ScheduleDTO;

@Repository
public class ScheduleDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public void inputEvent(ScheduleDTO event){
		mybatis.insert("schedule.inputEvent", event);
	}

	public List<ScheduleDTO> getAllEvents(){
		List<ScheduleDTO> events = mybatis.selectList("schedule.getAllEvents");
		return events;
	}
	
	public ScheduleDTO selectEvent(int id) {
		ScheduleDTO event = mybatis.selectOne("schedule.selectEvent", id);
		System.out.println("DAO : " + event.getStart_date());
		return event;
	}
	
	public void deleteById(int id) {
		mybatis.delete("schedule.deleteEvent",id);
	}
	
	public void updateById(ScheduleDTO evnet) {
		System.out.println("DAO");
		mybatis.update("schedule.updateById", evnet);
	}
}
