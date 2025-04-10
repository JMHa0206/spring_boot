package com.kedu.study.service.EDMS;

import java.util.List;

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

	public List<EDMSDTO> getPendingApprovals(int empCodeId) {
		return daoe.getPendingApproval(empCodeId);
	}

	public List<EDMSDTO> getMyDrafts(int empCodeId) {
		return daoe.getMyDrafts(empCodeId);
	}

	public EDMSDTO getEdmsDetail(Long id) {
		return daoe.getEdmsDetail(id);
	}
}
