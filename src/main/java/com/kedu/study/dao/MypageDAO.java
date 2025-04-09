package com.kedu.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.EmployeeDTO;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	private static final String nameSpace = "MypageMapper";
	
	public EmployeeDTO userinfo(String userId) {
		return mybatis.selectOne(nameSpace+".userinfo",userId);
	}
}
