package com.kedu.study.dto;

public class LoginResponseDTO {
	
    private String emp_name;
    private int emp_code_id;
    private String token;
    private int per_id;
    private String per_function;
    private int per_secure;
    
	public LoginResponseDTO() {
		super();
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_code_id() {
		return emp_code_id;
	}

	public void setEmp_code_id(int emp_code_id) {
		this.emp_code_id = emp_code_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}

	public String getPer_function() {
		return per_function;
	}

	public void setPer_function(String per_function) {
		this.per_function = per_function;
	}

	public int getPer_secure() {
		return per_secure;
	}

	public void setPer_secure(int per_secure) {
		this.per_secure = per_secure;
	}

	public LoginResponseDTO(String emp_name, int emp_code_id, String token, int per_id, String per_function,
			int per_secure) {
		super();
		this.emp_name = emp_name;
		this.emp_code_id = emp_code_id;
		this.token = token;
		this.per_id = per_id;
		this.per_function = per_function;
		this.per_secure = per_secure;
	}
}
