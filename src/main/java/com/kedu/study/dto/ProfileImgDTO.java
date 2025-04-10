package com.kedu.study.dto;

public class ProfileImgDTO {
	 private int profile_id;
	 private int profile_emp_id;
	 private String profile_path;
	 
	 public ProfileImgDTO() {}

	public ProfileImgDTO(int profile_id, int profile_emp_id, String profile_path) {
		super();
		this.profile_id = profile_id;
		this.profile_emp_id = profile_emp_id;
		this.profile_path = profile_path;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getProfile_emp_id() {
		return profile_emp_id;
	}

	public void setProfile_emp_id(int profile_emp_id) {
		this.profile_emp_id = profile_emp_id;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	
	 
	
}
