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

}