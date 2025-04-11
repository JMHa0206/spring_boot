package com.kedu.study.dto;

import java.util.Date;

public class BoardDTO {
	private Integer post_id; 
    private Integer parent_board;//
    private Integer post_writer;
    private String post_title;
    private String post_content;
    private Date post_date;
    private Integer post_view;
    private Integer post_like;//
    private String post_per;//
    private String post_tag;//
	
	BoardDTO(){}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public Integer getParent_board() {
		return parent_board;
	}

	public void setParent_board(Integer parent_board) {
		this.parent_board = parent_board;
	}

	public Integer getPost_writer() {
		return post_writer;
	}

	public void setPost_writer(Integer post_writer) {
		this.post_writer = post_writer;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public Integer getPost_view() {
		return post_view;
	}

	public void setPost_view(Integer post_view) {
		this.post_view = post_view;
	}

	public Integer getPost_like() {
		return post_like;
	}

	public void setPost_like(Integer post_like) {
		this.post_like = post_like;
	}

	public String getPost_per() {
		return post_per;
	}

	public void setPost_per(String post_per) {
		this.post_per = post_per;
	}

	public String getPost_tag() {
		return post_tag;
	}

	public void setPost_tag(String post_tag) {
		this.post_tag = post_tag;
	}

	public BoardDTO(Integer post_id, Integer parent_board, Integer post_writer, String post_title, String post_content,
			Date post_date, Integer post_view, Integer post_like, String post_per, String post_tag) {
		super();
		this.post_id = post_id;
		this.parent_board = parent_board;
		this.post_writer = post_writer;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_date = post_date;
		this.post_view = post_view;
		this.post_like = post_like;
		this.post_per = post_per;
		this.post_tag = post_tag;
	}

	
	

	
}