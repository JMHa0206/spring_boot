package com.kedu.study.dto;

public class CalendarShareDTO {
	
	private String target_type;
	private int target_id;
	
	public CalendarShareDTO() {}
	

	public CalendarShareDTO(String target_type, int target_id) {
		super();
		this.target_type = target_type;
		this.target_id = target_id;
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
