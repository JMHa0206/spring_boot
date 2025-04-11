package com.kedu.study.dao.EDMS;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ApproverInfoDTO;

@Repository
public class EDMSEmpDAO {

	@Autowired
	public SqlSessionTemplate mybatis;
	public int getEmpCodeIdByLoginId(String loginId) {
		return mybatis.selectOne("EmployeeMapper.findEmpCodeIdByLoginId",loginId);
	}
	public List<ApproverInfoDTO> getEmployeeList() {
		return mybatis.selectList("EmployeeMapper.takeAllemployee");
	}
	public ApproverInfoDTO getEmployeeById(int id) {
		return mybatis.selectOne("EmployeeMapper.takeEmployeeById",id);
	}
	public int getDeptIdByLoginId(String loginId) {
		return mybatis.selectOne("EmployeeMapper.takeDeptId",loginId);
	}

}
