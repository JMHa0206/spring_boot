package com.kedu.study.dto;

public class ChatRoomDTO {
	private int msg_group_id;
	private int msg_group_name;
	private int group_creator;
	private String group_member;
	private int num_members;
	private String emp_name;
	
	
	public ChatRoomDTO(int msg_group_id, int msg_group_name, String emp_name) {
		super();
		this.msg_group_id = msg_group_id;
		this.msg_group_name = msg_group_name;
		this.emp_name = emp_name;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public ChatRoomDTO(int msg_group_id, int msg_group_name) {
		super();
		this.msg_group_id = msg_group_id;
		this.msg_group_name = msg_group_name;
	}

	public ChatRoomDTO(int msg_group_id, int msg_group_name, int group_creator, String group_member,
			int num_members) {
		super();
		this.msg_group_id = msg_group_id;
		this.msg_group_name = msg_group_name;
		this.group_creator = group_creator;
		this.group_member = group_member;
		this.num_members = num_members;
	}
	
	public int getMsg_group_id() {
		return msg_group_id;
	}
	public void setMsg_group_id(int msg_group_id) {
		this.msg_group_id = msg_group_id;
	}
	public int getMsg_group_name() {
		return msg_group_name;
	}
	public void setMsg_group_name(int msg_group_name) {
		this.msg_group_name = msg_group_name;
	}
	public int getGroup_creator() {
		return group_creator;
	}
	public void setGroup_creator(int group_creator) {
		this.group_creator = group_creator;
	}
	public String getGroup_member() {
		return group_member;
	}
	public void setGroup_member(String group_member) {
		this.group_member = group_member;
	}
	public int getNum_members() {
		return num_members;
	}
	public void setNum_members(int num_members) {
		this.num_members = num_members;
	}
	

}
