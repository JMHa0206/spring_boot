package com.kedu.study.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReserveDTO {
	private int resv_id;
	private int resouce_id;
	private int resv_emp;
	private Date resv_date;
	private Timestamp resv_stime;
	private Timestamp resv_etime;
	private String resv_title;
	
	public ReserveDTO() {};
	public ReserveDTO(int resv_id, int resouce_id, int resv_emp, Date resv_date, Timestamp resv_stime,
			Timestamp resv_etime, String resv_title) {
		super();
		this.resv_id = resv_id;
		this.resouce_id = resouce_id;
		this.resv_emp = resv_emp;
		this.resv_date = resv_date;
		this.resv_stime = resv_stime;
		this.resv_etime = resv_etime;
		this.resv_title = resv_title;
	}
	public int getResv_id() {
		return resv_id;
	}
	public void setResv_id(int resv_id) {
		this.resv_id = resv_id;
	}
	public int getResouce_id() {
		return resouce_id;
	}
	public void setResouce_id(int resouce_id) {
		this.resouce_id = resouce_id;
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
	public Timestamp getResv_stime() {
		return resv_stime;
	}
	public void setResv_stime(Timestamp resv_stime) {
		this.resv_stime = resv_stime;
	}
	public Timestamp getResv_etime() {
		return resv_etime;
	}
	public void setResv_etime(Timestamp resv_etime) {
		this.resv_etime = resv_etime;
	}
	public String getResv_title() {
		return resv_title;
	}
	public void setResv_title(String resv_title) {
		this.resv_title = resv_title;
	}
	
	

}
