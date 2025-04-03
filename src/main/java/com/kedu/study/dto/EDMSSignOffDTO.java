package com.kedu.study.dto;

public class EDMSSignOffDTO {
    private Long stateCode;
    private String stateName;
    private String signOffName;

    public EDMSSignOffDTO() {}

    public Long getStateCode() {
        return stateCode;
    }

    public void setStateCode(Long stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getSignOffName() {
        return signOffName;
    }

    public void setSignOffName(String signOffName) {
        this.signOffName = signOffName;
    }
}
