package com.kedu.study.dto;

public class ApproverInfoDTO {

    private int empCodeId;
    private String empName;
    private int empJobId;
    private String jobName;
	public int getEmpCodeId() {
		return empCodeId;
	}
	public void setEmpCodeId(int empCodeId) {
		this.empCodeId = empCodeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpJobId() {
		return empJobId;
	}
	public void setEmpJobId(int empJobId) {
		this.empJobId = empJobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public ApproverInfoDTO(int empCodeId, String empName, int empJobId, String jobName) {
		super();
		this.empCodeId = empCodeId;
		this.empName = empName;
		this.empJobId = empJobId;
		this.jobName = jobName;
	}
	public ApproverInfoDTO() {
		super();
	}
    
    
	
}
