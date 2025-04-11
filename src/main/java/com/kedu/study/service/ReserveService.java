package com.kedu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.ReserveDAO;
import com.kedu.study.dto.RescTypeDTO;
import com.kedu.study.dto.ReserveDTO;
import com.kedu.study.dto.ResourceDTO;

@Service
public class ReserveService {
	@Autowired
	private ReserveDAO rDao;
	
	public List<RescTypeDTO> getResources(){
		return rDao.getResources();
	}
	
	public List<ResourceDTO> resourceList(){
		return rDao.resourceList();
	}
	
	public void addReserve(ReserveDTO reservation) {
		rDao.addReserve(reservation);
	}

}
