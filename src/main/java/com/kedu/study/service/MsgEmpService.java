package com.kedu.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MsgEmpDAO;
import com.kedu.study.dto.MsgEmpDTO;
import com.kedu.study.dto.MsgEmpMineDTO;

@Service
public class MsgEmpService {
	
	@Autowired
	private MsgEmpDAO eDao;
	
	public List<MsgEmpDTO> select(){
		
		return eDao.select();
	}
	
	public MsgEmpMineDTO selectMine(String userId){
		
		return eDao.selectMine(userId);
	}
	
	public int madeChatRoom(Map<String,String> names) {
		return eDao.madeChatRoom(names);
	}
	
	public boolean checkRoomExist(String targetname, String myname) {
	    return eDao.checkRoomExist(targetname, myname) > 0;
	}
	
}
