package com.kedu.study.dto;

import java.sql.Date;

public class PublicSCalendarDTO {
	private int c_id;
	private String c_title;
	private int emp_id;
	private int dept_code;
	private int public_code;
	private Date created_date;
	private String color;
	private String target_type;
	private int target_id;
	
	
	public PublicSCalendarDTO() {};
	public PublicSCalendarDTO(int c_id, String c_title, int emp_id, int dept_code, int public_code, Date created_date,
			String color, String target_type, int target_id) {
		super();
		this.c_id = c_id;
		this.c_title = c_title;
		this.emp_id = emp_id;
		this.dept_code = dept_code;
		this.public_code = public_code;
		this.created_date = created_date;
		this.color = color;
		this.target_type = target_type;
		this.target_id = target_id;
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
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}
	public int getTarget_id() {
		return target_id;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
	
	

}
