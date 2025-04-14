package com.kedu.study.dto;
// 출근 유무
public class AbsentDTO {
	private String empName; 
    private String deptName; 
    
    public AbsentDTO() {}
    
	public AbsentDTO(String empName, String deptName) {
		super();
		this.empName = empName;
		this.deptName = deptName;
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
}
