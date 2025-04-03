package com.kedu.study.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduleDTO {
	
	private int schedule_id;
	private int s_category_id;
	private int s_emp_id;
	private int s_dept_id;
	private String schedule_title;
	private String schedule_content;
	private LocalDate start_date;
	private LocalDate end_date;
	private Timestamp startTime;
	private Timestamp endTime;
	
	
	public ScheduleDTO() {};
	
	public ScheduleDTO(int schedule_id, int s_category_id, int s_emp_id, int s_dept_id, String schedule_title,
			String schedule_content, LocalDate start_date, LocalDate end_date, Timestamp startTime,
			Timestamp endTime) {
		super();
		this.schedule_id = schedule_id;
		this.s_category_id = s_category_id;
		this.s_emp_id = s_emp_id;
		this.s_dept_id = s_dept_id;
		this.schedule_title = schedule_title;
		this.schedule_content = schedule_content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getS_category_id() {
		return s_category_id;
	}
	public void setS_category_id(int s_category_id) {
		this.s_category_id = s_category_id;
	}
	public int getS_emp_id() {
		return s_emp_id;
	}
	public void setS_emp_id(int s_emp_id) {
		this.s_emp_id = s_emp_id;
	}
	public int getS_dept_id() {
		return s_dept_id;
	}
	public void setS_dept_id(int s_dept_id) {
		this.s_dept_id = s_dept_id;
	}
	public String getSchedule_title() {
		return schedule_title;
	}
	public void setSchedule_title(String schedule_title) {
		this.schedule_title = schedule_title;
	}
	public String getSchedule_content() {
		return schedule_content;
	}
	public void setSchedule_content(String schedule_content) {
		this.schedule_content = schedule_content;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
	
	
}
