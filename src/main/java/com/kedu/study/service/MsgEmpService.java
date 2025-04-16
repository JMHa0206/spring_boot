package com.kedu.study.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedu.study.dao.MsgEmpDAO;
import com.kedu.study.dto.ChattingRoomDTO;
import com.kedu.study.dto.MessageDTO;
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
	
	public int madeChatRoom(Map<String,Object> names) {
		return eDao.madeChatRoom(names);
	}
	
	public boolean checkRoomExist(String targetname, String myname) {
	    return eDao.checkRoomExist(targetname, myname) > 0;
	}
	
	public Map<String,Object> checkRoomSeqExist(int targetId,int myId){
		return eDao.checkRoomSeqExist(targetId,myId);
	}
	
	public List<MessageDTO> showMessages(int seq) {
		return eDao.showMessages(seq);
	}
	
	public int selectMyId(String userId) {
		return eDao.selectMyId(userId);
	}
	
	public List<Map<String, Object>> selectRoom(int myId) {
		return eDao.selectRoom(myId);
	}
	
	public int madeGroupChat(String selectedStr, Integer myId,Integer numMembers) {
		return eDao.madeGroupChat(selectedStr,myId,numMembers);
	}
	
	public List<ChattingRoomDTO> selectGroupChat(int myId) {
		return eDao.selectGroupChat(myId);
	}
	
	public List<String> getNamesIds(List<String> ids) {
		return eDao.getNamesIds(ids);
	}
	
	public List<Map<String,Object>> getGroupInfo(List<Integer> groupId){
		return eDao.getGroupInfo(groupId);
	}
	
	public int inviteToChat(Map<String,Object> data,List<Integer> mergedList) {
		return eDao.inviteToChat(data,mergedList);
	}
	
	public int quitRoom(Integer myId,Integer msgGroupId) {
		return eDao.quitRoom(myId,msgGroupId);
	}
	
	public String ProfileImg(int empId) {
		return eDao.ProfileImg(empId);
	}
	
	public List<Map<String,Object>> AllProfileImg(){
		return eDao.AllProfileImg();
	}
	
}
