package com.kedu.study.dto;

public class MsgEmpDTO {
	
	private int emp_code_id;
	private String emp_name;
	private String dept_name;
	
	
	public int getEmp_code_id() {
		return emp_code_id;
	}
	public void setEmp_code_id(int emp_code_id) {
		this.emp_code_id = emp_code_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public MsgEmpDTO(int emp_code_id, String emp_name, String dept_name) {
		super();
		this.emp_code_id = emp_code_id;
		this.emp_name = emp_name;
		this.dept_name = dept_name;
	}
	
}
