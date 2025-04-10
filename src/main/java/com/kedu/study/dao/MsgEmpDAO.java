package com.kedu.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.study.dto.ChattingRoomDTO;
import com.kedu.study.dto.MessageDTO;
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
	
	public int madeChatRoom(Map<String,Object> names) {
		return mybatis.insert("MsgEmp.madeChatRoom",names);
	}
	
	public int checkRoomExist(String targetname, String myname) {
	    Map<String, Object> map = new HashMap<>();
	    map.put("targetname", targetname);
	    map.put("myname", myname);
	    return mybatis.selectOne("MsgEmp.checkIfExists", map);
	}
	
	public Map<String,Object> checkRoomSeqExist(int targetId,int myId) {
		Map<String,Object> map = new HashMap<>();
		map.put("targetId", targetId);
		map.put("myId", myId);
		return mybatis.selectOne("MsgEmp.checkRoomSeqExist",map);
		
				
	}
	
	public List<MessageDTO> showMessages(int seq){
		return mybatis.selectList("MsgEmp.showMessages",seq);
	}
	
	public int selectMyId(String userId) {
		return mybatis.selectOne("MsgEmp.selectMyId",userId);
	}
	
	public List<Map<String,Object>> selectRoom(int myId){
		return mybatis.selectList("MsgEmp.selectRoom",myId);
	}
	
	public int madeGroupChat(String selectedStr, Integer myId, Integer numMembers ) {
		Map<String,Object> map = new HashMap<>();
		map.put("selectedStr", selectedStr);
		map.put("myId", myId);
		String combinedStr = selectedStr + "," + myId;
		map.put("combinedStr", combinedStr);
		map.put("numMembers", numMembers);
		
		mybatis.insert("MsgEmp.madeGroupChat",map);
		return (Integer)map.get("seq");
	}
	
	public List<ChattingRoomDTO> selectGroupChat(int myId) {
		return mybatis.selectList("MsgEmp.selectGroupChat",myId);
	}
	
	public List<String> getNamesIds(List<String> ids){
		return mybatis.selectList("MsgEmp.getNamesIds",ids);
	}
	
}
