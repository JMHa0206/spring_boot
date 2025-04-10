package com.kedu.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.DepartDTO;
import com.kedu.study.dto.EmployeeDTO;
import com.kedu.study.dto.LoginDTO;
import com.kedu.study.dto.LoginResponseDTO;

@Repository
public class EmployeeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	private static final String NameSpace = "EmployeeMapper"; // 너가 xml에서 설정한 namespace

	public LoginResponseDTO findByLoginIdAndPw(LoginDTO dto) {
	        return mybatis.selectOne(NameSpace + ".findByLoginIdAndPw", dto);
	}
	
	public List<EmployeeDTO> selectAllEmps(){
		return mybatis.selectList(NameSpace + ".selectAllEmps");
	}

	public List<DepartDTO> selectAllDepts(){
		return mybatis.selectList(NameSpace + ".selectAllDepts");
	}
	
}
