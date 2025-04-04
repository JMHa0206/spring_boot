package com.kedu.study.dto;

public class BoardDTO {
	private int board_id;
	private String board_name;
	private String board_title;
	private String board_content;
	private String board_wire_date;
	private int board_view;
	
	BoardDTO(){}

	public BoardDTO(int board_id, String board_name, String board_title, String board_content, String board_wire_date,
			int board_view) {
		super();
		this.board_id = board_id;
		this.board_name = board_name;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_wire_date = board_wire_date;
		this.board_view = board_view;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_wire_date() {
		return board_wire_date;
	}

	public void setBoard_wire_date(String board_wire_date) {
		this.board_wire_date = board_wire_date;
	}

	public int getBoard_view() {
		return board_view;
	}

	public void setBoard_view(int board_view) {
		this.board_view = board_view;
	}
	
}
