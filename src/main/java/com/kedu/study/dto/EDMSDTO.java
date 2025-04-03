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

    public EDMSDTO() {}

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
}
