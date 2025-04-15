package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.RescTypeDTO;
import com.kedu.study.dto.ReserveDTO;
import com.kedu.study.dto.ResourceDTO;

@Repository
public class ReserveDAO {
	@Autowired
	private SqlSession mybatis;
	
	public List<RescTypeDTO> getResources(){
		return mybatis.selectList("reserve.getResources");
	}
	
	public List<ResourceDTO> resourceList(){
		return mybatis.selectList("reserve.resourceList");
	}
	
	public void addReserve(ReserveDTO reservation) {
		mybatis.insert("reserve.addReserve", reservation);
	}
	
	public List<ReserveDTO> getAllResv(){
		List<ReserveDTO> list = mybatis.selectList("reserve.getAllResv");
		return list;
	}
	
	public void deleteById(int id) {
		mybatis.delete("reserve.deleteById", id);
	}
	
	public List<ReserveDTO> getMyResv(int id){
		return mybatis.selectList("reserve.getMyResv", id);
	}
	
	public int isOverlapping(ReserveDTO reservation) {
		return mybatis.selectOne("reserve.isOverlapping", reservation);
	}

}
