package com.kedu.study.dto;

public class ChattingRoomDTO {
	private Integer msg_group_id;
	private String msg_group_name;
	private String group_creator;
	private String group_member;
	private Integer num_members;
	
	
	
	public ChattingRoomDTO(Integer msg_group_id, String group_member) {
		super();
		this.msg_group_id = msg_group_id;
		this.group_member = group_member;
	}

	public ChattingRoomDTO(Integer msg_group_id) {
		super();
		this.msg_group_id = msg_group_id;
	}

	public ChattingRoomDTO(Integer msg_group_id, String msg_group_name, String group_creator, String group_member,
			Integer num_members) {
		super();
		this.msg_group_id = msg_group_id;
		this.msg_group_name = msg_group_name;
		this.group_creator = group_creator;
		this.group_member = group_member;
		this.num_members = num_members;
	}
	
	public Integer getMsg_group_id() {
		return msg_group_id;
	}
	public void setMsg_group_id(Integer msg_group_id) {
		this.msg_group_id = msg_group_id;
	}
	public String getMsg_group_name() {
		return msg_group_name;
	}
	public void setMsg_group_name(String msg_group_name) {
		this.msg_group_name = msg_group_name;
	}
	public String getGroup_creator() {
		return group_creator;
	}
	public void setGroup_creator(String group_creator) {
		this.group_creator = group_creator;
	}
	public String getGroup_member() {
		return group_member;
	}
	public void setGroup_member(String group_member) {
		this.group_member = group_member;
	}
	public Integer getNum_members() {
		return num_members;
	}
	public void setNum_members(Integer num_members) {
		this.num_members = num_members;
	}
	
}
