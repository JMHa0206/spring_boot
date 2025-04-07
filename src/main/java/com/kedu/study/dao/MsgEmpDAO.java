package com.kedu.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.MsgEmpDTO;
import com.kedu.study.dto.MsgEmpMineDTO;

@Repository
public class MsgEmpDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public List<MsgEmpDTO> select(){

		return mybatis.selectList("MsgEmp.select");
	}
	
	public MsgEmpMineDTO selectMine(String userId) {
		return mybatis.selectOne("MsgEmp.selectMine",userId);
	}
	
	public int madeChatRoom(Map<String,String> names) {
		return mybatis.insert("MsgEmp.madeChatRoom",names);
	}
	
	public int checkRoomExist(String targetname, String myname) {
	    Map<String, String> map = new HashMap<>();
	    map.put("targetname", targetname);
	    map.put("myname", myname);
	    return mybatis.selectOne("MsgEmp.checkIfExists", map);
	}
	
}
