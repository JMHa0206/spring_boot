package com.kedu.study.dto;

import java.sql.Date;

public class CalendarDTO {
	
	private int c_id;
	private String c_title;
	private int emp_id;
	private int dept_code;
	private int public_code;
	private Date created_date;
	private String color;
	
	public CalendarDTO() {};
	
	
	
	
	public CalendarDTO(int c_id, String c_title, int emp_id, int dept_code, int public_code, Date created_date,
			String color) {
		super();
		this.c_id = c_id;
		this.c_title = c_title;
		this.emp_id = emp_id;
		this.dept_code = dept_code;
		this.public_code = public_code;
		this.created_date = created_date;
		this.color = color;
	}




	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public Date getCreated_date() {
		return created_date;
	}


	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
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
