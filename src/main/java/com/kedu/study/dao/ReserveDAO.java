package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.RescTypeDTO;
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

}
