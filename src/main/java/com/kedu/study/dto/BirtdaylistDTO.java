package com.kedu.study.dto;
// 조휘영
public class BirtdaylistDTO {
	private String empname;
	private String deptname;
	private String emprrn;
	private boolean istoday; // 오늘 생일 여부
	
	public BirtdaylistDTO() {}
	
	public BirtdaylistDTO(String empname, String deptname, String emprrn, boolean istoday) {
		super();
		this.empname = empname;
		this.deptname = deptname;
		this.emprrn = emprrn;
		this.istoday = istoday;
	}
	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getEmprrn() {
		return emprrn;
	}
	public void setEmprrn(String emprrn) {
		this.emprrn = emprrn;
	}
	public Boolean getIstoday() { return istoday; }
	public void setIstoday(Boolean istoday) { this.istoday = istoday; }
	

}
