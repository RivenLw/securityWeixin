package com.Riven.ssm.tuling;

import java.io.Serializable;

public class ReqMsgPo implements Serializable{

	private int reqType;
	private Perception perception;
	private UserInfo userInfo;
	
	public int getReqType() {
		return reqType;
	}
	public void setReqType(int reqType) {
		this.reqType = reqType;
	}
	public Perception getPerception() {
		return perception;
	}
	public void setPerception(Perception perception) {
		this.perception = perception;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
