package com.kedu.study.dto;

// 조휘영
public class DepartmentAttendanceDTO {
	private String empName;
    private String deptName;
    private String checkInTime;
    private String checkOutTime;
    private String workDate;
    private double workHours;
    
    public DepartmentAttendanceDTO() {}

	public DepartmentAttendanceDTO(String empName, String deptName, String checkInTime, String checkOutTime,
			String workDate, double workHours) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.workDate = workDate;
		this.workHours = workHours;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public double getWorkHours() {
		return workHours;
	}

	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}
    
	
}
