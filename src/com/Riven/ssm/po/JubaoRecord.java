package com.Riven.ssm.po;

import java.util.List;

/**
 * null
 * 
 * 
 * @date 2018-05-07
 */
public class JubaoRecord {
    private Integer recordId;

    private String jubaoType;

    private String jubaoContent;

    private String name;

    private String phone;

    private String idcard;

    private String images;
    
    private List<String> base64codes;
    
    private List<String> imageNames;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

	public List<String> getBase64codes() {
		return base64codes;
	}

	public void setBase64codes(List<String> base64codes) {
		this.base64codes = base64codes;
	}

	public List<String> getImageNames() {
		return imageNames;
	}

	public void setImageNames(List<String> imageNames) {
		this.imageNames = imageNames;
	}

	@Override
	public String toString() {
		return "JubaoRecord [recordId=" + recordId + ", jubaoType=" + jubaoType + ", jubaoContent=" + jubaoContent
				+ ", name=" + name + ", phone=" + phone + ", idcard=" + idcard + ", images=" + images + ", base64codes="
				+ base64codes + ", imageNames=" + imageNames + "]";
	}
}