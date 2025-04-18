package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.ScheduleDAO;
import com.kedu.study.dto.ScheduleDTO;

@Service
public class ScheduleService {
		
	@Autowired
	private ScheduleDAO sDao;
		
	public void inputEvent(ScheduleDTO event){
			sDao.inputEvent(event);
	}
	
	public List<ScheduleDTO> getComEvents() {
		return sDao.getComEvents();
	}
	
	public List<ScheduleDTO> getMyEvents(int emp_cod_id) {
		return sDao.getMyEvents(emp_cod_id);
	}
	
	public List<ScheduleDTO> shareEvents(int emp_cod_id) {
		return sDao.shareEvents(emp_cod_id);
	}
	
	public ScheduleDTO selectEvent(int id) {
		ScheduleDTO event = sDao.selectEvent(id);
		System.out.println("Service : " + event.getStart_date());
		return event;
	}
	
	public void deleteById(int id) {
		sDao.deleteById(id);
		
	}
	
	public void updateById(int id, ScheduleDTO event) {
		System.out.println("Service");
		event.setId(id);
		sDao.updateById(event);
	}
	
	public List<ScheduleDTO> todaySchedule(int emp_code_id){
		return sDao.todaySchedule(emp_code_id);
	}

}