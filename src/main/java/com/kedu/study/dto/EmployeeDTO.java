package com.kedu.study.dto;

public class EmployeeDTO {

    private int emp_code_id;
    private int emp_per_id;
    private int emp_dept_id;
    private int emp_job_id;
    private String emp_loginId;
    private String emp_pw;
    private String emp_name;
    private String emp_rrn;
    private String emp_phone;
    private String emp_email;
    private String postcode;
    private String address1;
    private String address2;
    private String hire_date;
    private int salary;
    private String isDeft;
    
    public EmployeeDTO(){};

    public EmployeeDTO(int emp_code_id, int emp_per_id, int emp_dept_id, int emp_job_id, String emp_loginId,
			String emp_pw, String emp_name, String emp_rrn, String emp_phone, String emp_email, String postcode,
			String address1, String address2, String hire_date, int salary, String isDeft) {
		super();
		this.emp_code_id = emp_code_id;
		this.emp_per_id = emp_per_id;
		this.emp_dept_id = emp_dept_id;
		this.emp_job_id = emp_job_id;
		this.emp_loginId = emp_loginId;
		this.emp_pw = emp_pw;
		this.emp_name = emp_name;
		this.emp_rrn = emp_rrn;
		this.emp_phone = emp_phone;
		this.emp_email = emp_email;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
		this.hire_date = hire_date;
		this.salary = salary;
		this.isDeft = isDeft;
	}
	// 기본 객체로 초기화
    private JobDTO jobDTO = new JobDTO();
    private DepartDTO departDTO = new DepartDTO();
    private ProfileImgDTO profileDTO;
   
	public int getEmp_code_id() {
		return emp_code_id;
	}
	public void setEmp_code_id(int emp_code_id) {
		this.emp_code_id = emp_code_id;
	}
	public int getEmp_per_id() {
		return emp_per_id;
	}
	public void setEmp_per_id(int emp_per_id) {
		this.emp_per_id = emp_per_id;
	}
	public int getEmp_dept_id() {
		return emp_dept_id;
	}
	public void setEmp_dept_id(int emp_dept_id) {
		this.emp_dept_id = emp_dept_id;
	}
	public int getEmp_job_id() {
		return emp_job_id;
	}
	public void setEmp_job_id(int emp_job_id) {
		this.emp_job_id = emp_job_id;
	}
	public String getEmp_loginId() {
		return emp_loginId;
	}
	public void setEmp_loginId(String emp_loginId) {
		this.emp_loginId = emp_loginId;
	}
	public String getEmp_pw() {
		return emp_pw;
	}
	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_rrn() {
		return emp_rrn;
	}
	public void setEmp_rrn(String emp_rrn) {
		this.emp_rrn = emp_rrn;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getIsDeft() {
		return isDeft;
	}
	public void setIsDeft(String isDeft) {
		this.isDeft = isDeft;
	}
	public JobDTO getJobDTO() {
		return jobDTO;
	}
	public void setJobDTO(JobDTO jobDTO) {
		this.jobDTO = jobDTO;
	}
	public DepartDTO getDepartDTO() {
		return departDTO;
	}
	public void setDepartDTO(DepartDTO departDTO) {
		this.departDTO = departDTO;
	}
	public ProfileImgDTO getProfileDTO() {
		return profileDTO;
	}
	public void setProfileDTO(ProfileImgDTO profileDTO) {
		this.profileDTO = profileDTO;
	}


}
