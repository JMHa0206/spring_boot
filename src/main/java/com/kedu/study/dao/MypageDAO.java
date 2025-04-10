package com.kedu.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.dto.ProfileImgDTO;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	private static final String nameSpace = "MypageMapper";
	
	public EmployeeDTO userinfo(String userId) {
		return mybatis.selectOne(nameSpace+".userinfo",userId);
	}
	public int userupdate(EmployeeDTO Empdto) {
		return mybatis.update(nameSpace+".userupdate",Empdto);
	}
	public void saveProfile(ProfileImgDTO profileDTO) {
	    mybatis.insert(nameSpace + ".saveProfile", profileDTO);
	}

}
