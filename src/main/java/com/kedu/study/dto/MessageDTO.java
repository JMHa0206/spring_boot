package com.kedu.study.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MessageDTO {
	private int msg_id;
	private int msg_group_id;
	private int msg_emp_id;
	private String msg_content;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp send_date;
	private String read;
	
	
	public MessageDTO(int msg_id, int msg_group_id, int msg_emp_id, String msg_content, Timestamp send_date, String read) {
		super();
		this.msg_id = msg_id;
		this.msg_group_id = msg_group_id;
		this.msg_emp_id = msg_emp_id;
		this.msg_content = msg_content;
		this.send_date = send_date;
		this.read = read;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public int getMsg_group_id() {
		return msg_group_id;
	}
	public void setMsg_group_id(int msg_group_id) {
		this.msg_group_id = msg_group_id;
	}
	public int getMsg_emp_id() {
		return msg_emp_id;
	}
	public void setMsg_emp_id(int msg_emp_id) {
		this.msg_emp_id = msg_emp_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Timestamp getSend_date() {
		return send_date;
	}
	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	
	
}
