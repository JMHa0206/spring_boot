package com.kedu.study.dto;

public class EDMSFileDTO {
    private Long edmsFileId;
    private Long parentSeq;
    private String edmsOriName;
    private String edmsSysName;

    public EDMSFileDTO() {}

    public Long getEdmsFileId() {
        return edmsFileId;
    }

    public void setEdmsFileId(Long edmsFileId) {
        this.edmsFileId = edmsFileId;
    }

    public Long getParentSeq() {
        return parentSeq;
    }

    public void setParentSeq(Long parentSeq) {
        this.parentSeq = parentSeq;
    }

    public String getEdmsOriName() {
        return edmsOriName;
    }

    public void setEdmsOriName(String edmsOriName) {
        this.edmsOriName = edmsOriName;
    }

    public String getEdmsSysName() {
        return edmsSysName;
    }

    public void setEdmsSysName(String edmsSysName) {
        this.edmsSysName = edmsSysName;
    }
}
