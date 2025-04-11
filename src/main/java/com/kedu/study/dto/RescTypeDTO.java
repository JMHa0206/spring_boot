package com.kedu.study.dto;

public class RescTypeDTO {
	
	private int resc_type_id;
	private String resc_type;
	
	public RescTypeDTO() {};
	public RescTypeDTO(int resc_type_id, String resc_type) {
		super();
		this.resc_type_id = resc_type_id;
		this.resc_type = resc_type;
	}
	public int getResc_type_id() {
		return resc_type_id;
	}
	public void setResc_type_id(int resc_type_id) {
		this.resc_type_id = resc_type_id;
	}
	public String getResc_type() {
		return resc_type;
	}
	public void setResc_type(String resc_type) {
		this.resc_type = resc_type;
	}
	
	

}
