package com.kedu.study.dto;

import java.sql.Timestamp;

public class AttendanceDTO {
	private int attendance_id;
	private String emp_loginId;	//사원아이디
	private Timestamp record_date ;
	private Timestamp check_in_time;
	private Timestamp check_out_time;
	private String status;
	private String reason;
	private Double work_hours;
	private Double overtime_hours;
	private Timestamp created_at;
	
	public AttendanceDTO() {}
	
	public AttendanceDTO(int attendance_id, String emp_loginId, Timestamp record_date, Timestamp check_in_time,
			Timestamp check_out_time, String status, String reason, Double work_hours, Double overtime_hours,
			Timestamp created_at) {
		super();
		this.attendance_id = attendance_id;
		this.emp_loginId = emp_loginId;
		this.record_date = record_date;
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
		this.status = status;
		this.reason = reason;
		this.work_hours = work_hours;
		this.overtime_hours = overtime_hours;
		this.created_at = created_at;
	}
	
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	
	public String getEmp_loginId() {
		return emp_loginId;
	}

	public void setEmp_loginId(String emp_loginId) {
		this.emp_loginId = emp_loginId;
	}

	public Timestamp getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Timestamp record_date) {
		this.record_date = record_date;
	}
	public Timestamp getCheck_in_time() {
		return check_in_time;
	}
	public void setCheck_in_time(Timestamp check_in_time) {
		this.check_in_time = check_in_time;
	}
	public Timestamp getCheck_out_time() {
		return check_out_time;
	}
	public void setCheck_out_time(Timestamp check_out_time) {
		this.check_out_time = check_out_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Double getWork_hours() {
		return work_hours;
	}
	public void setWork_hours(Double work_hours) {
		this.work_hours = work_hours;
	}
	public Double getOvertime_hours() {
		return overtime_hours;
	}
	public void setOvertime_hours(Double overtime_hours) {
		this.overtime_hours = overtime_hours;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
}
