package com.kedu.study.dto;

import java.util.Date;

public class EDMSHistoryDTO {
	
    private Long historyId;
    private Long edmsId;
    private Integer approverId;
    private String action;      // APPROVE / REJECT
    private Integer stepLevel;
    private String reason;
    private Date actionDate;
    
	public EDMSHistoryDTO() {
		super();
	}
	public EDMSHistoryDTO(Long historyId, Long edmsId, Integer approverId, String action, Integer stepLevel,
			String reason, Date actionDate) {
		super();
		this.historyId = historyId;
		this.edmsId = edmsId;
		this.approverId = approverId;
		this.action = action;
		this.stepLevel = stepLevel;
		this.reason = reason;
		this.actionDate = actionDate;
	}
	public Long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}
	public Long getEdmsId() {
		return edmsId;
	}
	public void setEdmsId(Long edmsId) {
		this.edmsId = edmsId;
	}
	public Integer getApproverId() {
		return approverId;
	}
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getStepLevel() {
		return stepLevel;
	}
	public void setStepLevel(Integer stepLevel) {
		this.stepLevel = stepLevel;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
}
