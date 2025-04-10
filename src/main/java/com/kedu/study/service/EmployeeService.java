package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO eDao;

}
