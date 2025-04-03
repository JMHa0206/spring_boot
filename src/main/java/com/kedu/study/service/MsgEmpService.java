package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MsgEmpDAO;
import com.kedu.study.dto.MsgEmpDTO;

@Service
public class MsgEmpService {
	
	@Autowired
	private MsgEmpDAO eDao;
	
	public List<MsgEmpDTO> select(){
		
		return eDao.select();
	}
}
