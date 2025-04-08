package com.kedu.study.dto;

public class CalendarDTO {
	
	private int c_id;
	private String c_title;
	private int dept_code;
	private int public_code;
	private String color;
	
	public CalendarDTO() {};
	
	public CalendarDTO(int c_id, String c_title, int dept_code, int public_code, String color) {
		super();
		this.c_id = c_id;
		this.c_title = c_title;
		this.dept_code = dept_code;
		this.public_code = public_code;
		this.color = color;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public int getDept_code() {
		return dept_code;
	}
	public void setDept_code(int dept_code) {
		this.dept_code = dept_code;
	}
	public int getPublic_code() {
		return public_code;
	}
	public void setPublic_code(int public_code) {
		this.public_code = public_code;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
