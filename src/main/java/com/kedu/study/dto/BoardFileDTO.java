package com.kedu.study.dto;

public class BoardFileDTO {
	private int b_file_id;
	private int parent_post;
	private String b_oriname;
	private String b_sysname;
	
	public BoardFileDTO(){}
	public int getB_file_id() {
		return b_file_id;
	}
	public void setB_file_id(int b_file_id) {
		this.b_file_id = b_file_id;
	}
	public int getParent_post() {
		return parent_post;
	}
	public void setParent_post(int parent_post) {
		this.parent_post = parent_post;
	}
	public String getB_oriname() {
		return b_oriname;
	}
	public void setB_oriname(String b_oriname) {
		this.b_oriname = b_oriname;
	}
	public String getB_sysname() {
		return b_sysname;
	}
	public void setB_sysname(String b_sysname) {
		this.b_sysname = b_sysname;
	}
	public BoardFileDTO(int b_file_id, int parent_post, String b_oriname, String b_sysname) {
		super();
		this.b_file_id = b_file_id;
		this.parent_post = parent_post;
		this.b_oriname = b_oriname;
		this.b_sysname = b_sysname;
	}
	
}
