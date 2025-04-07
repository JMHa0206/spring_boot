package com.kedu.study.dto;

public class MadeChatRoomDTO {
	private String targetname;
	private String myname;
	
	public MadeChatRoomDTO(String targetname, String myname) {
		super();
		this.targetname = targetname;
		this.myname = myname;
	}
	public String getTargetname() {
		return targetname;
	}
	public void setTargetname(String targetname) {
		this.targetname = targetname;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	
}
