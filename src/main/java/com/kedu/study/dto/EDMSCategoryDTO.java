package com.kedu.study.dto;

public class EDMSCategoryDTO {
    private Long edmsCId;
    private String edmsCName;
	public Long getEdmsCId() {
		return edmsCId;
	}
	public void setEdmsCId(Long edmsCId) {
		this.edmsCId = edmsCId;
	}
	public String getEdmsCName() {
		return edmsCName;
	}
	public void setEdmsCName(String edmsCName) {
		this.edmsCName = edmsCName;
	}
	public EDMSCategoryDTO(Long edmsCId, String edmsCName) {
		super();
		this.edmsCId = edmsCId;
		this.edmsCName = edmsCName;
	}
	public EDMSCategoryDTO() {
		super();
	}

    
}
