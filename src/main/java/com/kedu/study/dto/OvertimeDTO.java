package com.kedu.study.dto;

public class OvertimeDTO {
	private String empName;
    private String deptName;
    private String workDate;
    private double workHours;
    private double overtimeHours;
    
    public OvertimeDTO() {}
    
	public OvertimeDTO(String empName, String deptName, String workDate, double workHours, double overtimeHours) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.workDate = workDate;
		this.workHours = workHours;
		this.overtimeHours = overtimeHours;
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
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
}
