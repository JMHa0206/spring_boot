package com.kedu.study.dto;

public class ScheduleCategoryDTO {
	
	private int s_c_id;
	private String s_c_name;
	private String color;
	
	public ScheduleCategoryDTO() {};
	
	public ScheduleCategoryDTO(int s_c_id, String s_c_name, String color) {
		super();
		this.s_c_id = s_c_id;
		this.s_c_name = s_c_name;
		this.color = color;
	}
	public int getS_c_id() {
		return s_c_id;
	}
	public void setS_c_id(int s_c_id) {
		this.s_c_id = s_c_id;
	}
	public String getS_c_name() {
		return s_c_name;
	}
	public void setS_c_name(String s_c_name) {
		this.s_c_name = s_c_name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
