package com.kedu.study.service.EDMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSDAO;
import com.kedu.study.dto.EDMSDTO;

@Service
public class EDMSService {
	
	@Autowired
	public EDMSDAO daoe;
	
	public int insertEDMS(EDMSDTO edms) {
		return daoe.insertEDMS(edms);
	}
}
