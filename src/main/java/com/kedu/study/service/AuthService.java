package com.kedu.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EmployeeDAO;
import com.kedu.study.dto.LoginDTO;
import com.kedu.study.dto.LoginResponseDTO;

@Service
public class AuthService {

	@Autowired
	private EmployeeDAO daoe;

	public LoginResponseDTO findByLoginIdAndPw(LoginDTO dto) {
		System.out.println("1");
		return daoe.findByLoginIdAndPw(dto);
	}
	
	 
}
