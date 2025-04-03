package com.kedu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.MsgEmpDTO;

@Repository
public class MsgEmpDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public List<MsgEmpDTO> select(){

		return mybatis.selectList("MsgEmp.select");
	}
	
}
