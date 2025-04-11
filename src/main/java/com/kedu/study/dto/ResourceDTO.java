package com.kedu.study.dto;

public class ResourceDTO {
	
	private int resc_id;
	private String resc_name;
	private int resc_type_id;
	private int resc_capacity;
	private String recs_location;
	private String resc_status;
	private String resc_description;
	
	public ResourceDTO() {};
	public ResourceDTO(int resc_id, String resc_name, int resc_type_id, int resc_capacity, String recs_location,
			String resc_status, String resc_description) {
		super();
		this.resc_id = resc_id;
		this.resc_name = resc_name;
		this.resc_type_id = resc_type_id;
		this.resc_capacity = resc_capacity;
		this.recs_location = recs_location;
		this.resc_status = resc_status;
		this.resc_description = resc_description;
	}
	public int getResc_id() {
		return resc_id;
	}
	public void setResc_id(int resc_id) {
		this.resc_id = resc_id;
	}
	public String getResc_name() {
		return resc_name;
	}
	public void setResc_name(String resc_name) {
		this.resc_name = resc_name;
	}
	public int getResc_type_id() {
		return resc_type_id;
	}
	public void setResc_type_id(int resc_type_id) {
		this.resc_type_id = resc_type_id;
	}
	public int getResc_capacity() {
		return resc_capacity;
	}
	public void setResc_capacity(int resc_capacity) {
		this.resc_capacity = resc_capacity;
	}
	public String getRecs_location() {
		return recs_location;
	}
	public void setRecs_location(String recs_location) {
		this.recs_location = recs_location;
	}
	public String getResc_status() {
		return resc_status;
	}
	public void setResc_status(String resc_status) {
		this.resc_status = resc_status;
	}
	public String getResc_description() {
		return resc_description;
	}
	public void setResc_description(String resc_description) {
		this.resc_description = resc_description;
	}
	
	

}
