package com.Riven.ssm.po;

/**
 * null
 * 
 * @author wcyong
 * 
 * @date 2018-05-02
 */
public class JubaoRecord {
    private Integer recordId;

    private String jubaoType;

    private String jubaoContent;

    private String name;

    private String phone;

    private String idcard;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getJubaoType() {
        return jubaoType;
    }

    public void setJubaoType(String jubaoType) {
        this.jubaoType = jubaoType == null ? null : jubaoType.trim();
    }

    public String getJubaoContent() {
        return jubaoContent;
    }

    public void setJubaoContent(String jubaoContent) {
        this.jubaoContent = jubaoContent == null ? null : jubaoContent.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }
}