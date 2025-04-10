package com.kedu.study.dto;

import java.util.Date;

public class EDMSDTO {
    private Long edmsId;
    private Long formId;
    private Long edmsCId;
    private Long comId;
    private Long stateCode;

    private String edmsTitle;
    private String edmsContent;
    private Date submitDate;
    private String refDept;
    private String rejectReason;

    private Integer level1;
    private Integer level2;
    private Integer level3;
    private Integer level4;
    private Integer finalLevel;
    
    private Date startDate;
    private Date endDate;
    
    private String drafterName;
    private String formName;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getDrafterName() {
		return drafterName;
	}

	public void setDrafterName(String drafterName) {
		this.drafterName = drafterName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

    public Long getEdmsId() {
        return edmsId;
    }
    public void setEdmsId(Long edmsId) {
        this.edmsId = edmsId;
    }

    public Long getFormId() {
        return formId;
    }
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getEdmsCId() {
        return edmsCId;
    }
    public void setEdmsCId(Long edmsCId) {
        this.edmsCId = edmsCId;
    }

    public Long getComId() {
        return comId;
    }
    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getStateCode() {
        return stateCode;
    }
    public void setStateCode(Long stateCode) {
        this.stateCode = stateCode;
    }

    public String getEdmsTitle() {
        return edmsTitle;
    }
    public void setEdmsTitle(String edmsTitle) {
        this.edmsTitle = edmsTitle;
    }

    public String getEdmsContent() {
        return edmsContent;
    }
    public void setEdmsContent(String edmsContent) {
        this.edmsContent = edmsContent;
    }

    public Date getSubmitDate() {
        return submitDate;
    }
    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getRefDept() {
        return refDept;
    }
    public void setRefDept(String refDept) {
        this.refDept = refDept;
    }

    public String getRejectReason() {
        return rejectReason;
    }
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getLevel1() {
        return level1;
    }
    public void setLevel1(Integer level1) {
        this.level1 = level1;
    }

    public Integer getLevel2() {
        return level2;
    }
    public void setLevel2(Integer level2) {
        this.level2 = level2;
    }

    public Integer getLevel3() {
        return level3;
    }
    public void setLevel3(Integer level3) {
        this.level3 = level3;
    }

    public Integer getLevel4() {
        return level4;
    }
    public void setLevel4(Integer level4) {
        this.level4 = level4;
    }

    public Integer getFinalLevel() {
        return finalLevel;
    }
    public void setFinalLevel(Integer finalLevel) {
        this.finalLevel = finalLevel;
    }

	public EDMSDTO(Long edmsId, Long formId, Long edmsCId, Long comId, Long stateCode, String edmsTitle,
			String edmsContent, Date submitDate, String refDept, String rejectReason, Integer level1, Integer level2,
			Integer level3, Integer level4, Integer finalLevel, Date startDate, Date endDate) {
		super();
		this.edmsId = edmsId;
		this.formId = formId;
		this.edmsCId = edmsCId;
		this.comId = comId;
		this.stateCode = stateCode;
		this.edmsTitle = edmsTitle;
		this.edmsContent = edmsContent;
		this.submitDate = submitDate;
		this.refDept = refDept;
		this.rejectReason = rejectReason;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.level4 = level4;
		this.finalLevel = finalLevel;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public EDMSDTO() {
		super();
	}
    
    
}
