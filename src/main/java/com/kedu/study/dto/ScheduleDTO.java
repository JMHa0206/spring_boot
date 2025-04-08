package com.kedu.study.dto;

import java.time.LocalDate;
import java.time.LocalTime;



public class ScheduleDTO {
	
	private long id;
	private int category_id;
	private String title;
	private String content;
	private LocalDate start_date;
	private LocalDate end_date;
	private LocalTime startTime;
	private LocalTime endTime;
	
	
	public ScheduleDTO() {}


	public ScheduleDTO(long id, int category_id, String title, String content, LocalDate start, LocalDate end,
			LocalTime startTime, LocalTime endTime) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.title = title;
		this.content = content;
		this.start_date = start;
		this.end_date = end;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
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


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	};
	
	
	
	
	
}
