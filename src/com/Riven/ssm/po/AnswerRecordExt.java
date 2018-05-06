package com.Riven.ssm.po;

import java.util.List;

public class AnswerRecordExt extends AnswerRecord{

	private String zhengquelv;
	
	private List<String> truelist;
	
	private List<String> falselist;
	
	private String useTime;

	public String getZhengquelv() {
		return zhengquelv;
	}

	public void setZhengquelv(String zhengquelv) {
		this.zhengquelv = zhengquelv;
	}

	public List<String> getTruelist() {
		return truelist;
	}

	public void setTruelist(List<String> truelist) {
		this.truelist = truelist;
	}

	public List<String> getFalselist() {
		return falselist;
	}

	public void setFalselist(List<String> falselist) {
		this.falselist = falselist;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	
}
