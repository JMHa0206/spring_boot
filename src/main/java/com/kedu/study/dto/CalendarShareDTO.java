package com.kedu.study.dto;

public class CalendarShareDTO {
	
	private int c_id;
	private String target_type;
	private int target_id;
	
	public CalendarShareDTO() {}
	

	public CalendarShareDTO(int c_id, String target_type, int target_id) {
		super();
		this.c_id=c_id;
		this.target_type = target_type;
		this.target_id = target_id;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public String getTarget_type() {
		return target_type;
	}

	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}

	public int getTarget_id() {
		return target_id;
	}

	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	};
	
	
	

}
