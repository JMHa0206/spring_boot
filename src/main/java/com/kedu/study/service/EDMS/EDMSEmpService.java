package com.kedu.study.service.EDMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSEmpDAO;

@Service
public class EDMSEmpService {
	
	@Autowired
	public EDMSEmpDAO daoe;

	public int getEmpCodeIdByLoginId(String loginId) {
		return daoe.getEmpCodeIdByLoginId(loginId);
	}

}
