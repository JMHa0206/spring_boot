package com.kedu.study.dto;

public class MsgEmpMineDTO {
	private int emp_code_id;
	private int emp_dept_id;
	private String emp_name;
	
	
	public MsgEmpMineDTO(int emp_code_id, int emp_dept_id, String emp_name) {
		super();
		this.emp_code_id = emp_code_id;
		this.emp_dept_id = emp_dept_id;
		this.emp_name = emp_name;
	}
	public int getEmp_code_id() {
		return emp_code_id;
	}
	public void setEmp_code_id(int emp_code_id) {
		this.emp_code_id = emp_code_id;
	}
	public int getEmp_dept_id() {
		return emp_dept_id;
	}
	public void setEmp_dept_id(int emp_dept_id) {
		this.emp_dept_id = emp_dept_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
}
