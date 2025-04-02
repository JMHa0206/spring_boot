package com.kedu.study.dto;

public class LoginDTO {
	
	private String id;
	private String pw;
	
	public LoginDTO() {
		super();
	}
	public LoginDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
