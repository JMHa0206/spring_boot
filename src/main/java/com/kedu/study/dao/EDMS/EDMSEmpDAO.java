package com.kedu.study.dao.EDMS;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EDMSEmpDAO {

	@Autowired
	public SqlSessionTemplate mybatis;
	public int getEmpCodeIdByLoginId(String loginId) {
		return mybatis.selectOne("EmployeeMapper.findEmpCodeIdByLoginId",loginId);
	}

}
