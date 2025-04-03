package com.kedu.study.dto;

import java.security.Timestamp;

public class ActivityDTO {
	private int activity_id;
	private int attendance_id;
	private String activity_type;
	private Timestamp start_time;
	private Timestamp end_time;
	private Double activity_hours;
	
	public ActivityDTO() {}
	
	public ActivityDTO(int activity_id, int attendance_id, String activity_type, Timestamp start_time,
			Timestamp end_time, Double activity_hours) {
		super();
		this.activity_id = activity_id;
		this.attendance_id = attendance_id;
		this.activity_type = activity_type;
		this.start_time = start_time;
		this.end_time = end_time;
		this.activity_hours = activity_hours;
	}
	
	
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public Double getActivity_hours() {
		return activity_hours;
	}
	public void setActivity_hours(Double activity_hours) {
		this.activity_hours = activity_hours;
	}
}
