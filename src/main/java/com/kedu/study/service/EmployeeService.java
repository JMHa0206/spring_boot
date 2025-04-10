package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EmployeeDAO;
import com.kedu.study.dto.DepartDTO;
import com.kedu.study.dto.EmployeeDTO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO eDao;
	
	public List<EmployeeDTO> selectAllEmps(){
		return eDao.selectAllEmps();
	}
	
	public List<DepartDTO> selectAllDepts(){
		return eDao.selectAllDepts();
	}

}
