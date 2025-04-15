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
	
	public List<ReserveDTO> getAllResv(){
		return rDao.getAllResv();
	}
	
	public void deleteById(int id) {
		rDao.deleteById(id);
	}
	
	public List<ReserveDTO> getMyResv(int id){
		return rDao.getMyResv(id);
	}
	
	public boolean isOverlapping(ReserveDTO reservation) {
		int count = rDao.isOverlapping(reservation);
		System.out.println(count);
	    return count > 0;
	}


}
