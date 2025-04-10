package com.kedu.study.service.EDMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.EDMS.EDMSEmpDAO;
import com.kedu.study.dto.ApproverInfoDTO;

@Service
public class EDMSEmpService {
	
	@Autowired
	public EDMSEmpDAO daoe;

	public int getEmpCodeIdByLoginId(String loginId) {
		return daoe.getEmpCodeIdByLoginId(loginId);
	}

	public List<ApproverInfoDTO> getEmployeeList() {
		return daoe.getEmployeeList();
	}

	public ApproverInfoDTO getEmployeeById(int id) {
		return daoe.getEmployeeById(id);
	}

}
