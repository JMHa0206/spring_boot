package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.ScheduleDAO;
import com.kedu.study.dto.ScheduleCategoryDTO;
import com.kedu.study.dto.ScheduleDTO;

@Service
public class ScheduleService {
		
	@Autowired
	private ScheduleDAO sDao;
		
	public void inputEvent(ScheduleDTO event){
			sDao.inputEvent(event);
	}
	
	public List<ScheduleDTO> getAllEvents() {
		return sDao.getAllEvents();
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

}