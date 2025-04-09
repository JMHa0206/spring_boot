package com.kedu.study.dto;

public class BoardReplyDTO {
	private Integer reply_id;
	private Integer board_id;
	private String reply_coontent;
	private String reply_writer;
	private String reply_date;
	
	public Integer getReply_id() {
		return reply_id;
	}
	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getReply_coontent() {
		return reply_coontent;
	}
	public void setReply_coontent(String reply_coontent) {
		this.reply_coontent = reply_coontent;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	
	BoardReplyDTO(){}
	public BoardReplyDTO(Integer reply_id, Integer board_id, String reply_coontent, String reply_writer,
			String reply_date) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.reply_coontent = reply_coontent;
		this.reply_writer = reply_writer;
		this.reply_date = reply_date;
	}
	
}
