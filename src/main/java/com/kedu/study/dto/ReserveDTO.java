package com.kedu.study.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;

public class ReserveDTO {
	private int resv_id;
	private int resource_id;
	private int resv_emp;
	private Date resv_date;
	private String  resv_stime;
	private String  resv_etime;
	private String resv_title;
	private String resc_name;
	private int resc_type_id;
	
	public ReserveDTO() {}

	public ReserveDTO(int resv_id, int resource_id, int resv_emp, Date resv_date, String resv_stime, String resv_etime,
			String resv_title, String resc_name, int resc_type_id) {
		super();
		this.resv_id = resv_id;
		this.resource_id = resource_id;
		this.resv_emp = resv_emp;
		this.resv_date = resv_date;
		this.resv_stime = resv_stime;
		this.resv_etime = resv_etime;
		this.resv_title = resv_title;
		this.resc_name = resc_name;
		this.resc_type_id = resc_type_id;
	}

	public int getResv_id() {
		return resv_id;
	}

	public void setResv_id(int resv_id) {
		this.resv_id = resv_id;
	}

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

	public int getResv_emp() {
		return resv_emp;
	}

	public void setResv_emp(int resv_emp) {
		this.resv_emp = resv_emp;
	}

	public Date getResv_date() {
		return resv_date;
	}

	public void setResv_date(Date resv_date) {
		this.resv_date = resv_date;
	}

	public String getResv_stime() {
		return resv_stime;
	}

	public void setResv_stime(String resv_stime) {
		this.resv_stime = resv_stime;
	}

	public String getResv_etime() {
		return resv_etime;
	}

	public void setResv_etime(String resv_etime) {
		this.resv_etime = resv_etime;
	}

	public String getResv_title() {
		return resv_title;
	}

	public void setResv_title(String resv_title) {
		this.resv_title = resv_title;
	}

	public String getResc_name() {
		return resc_name;
	}

	public void setResc_name(String resc_name) {
		this.resc_name = resc_name;
	}

	public int getResc_type_id() {
		return resc_type_id;
	}

	public void setResc_type_id(int resc_type_id) {
		this.resc_type_id = resc_type_id;
	}
	
	

}
