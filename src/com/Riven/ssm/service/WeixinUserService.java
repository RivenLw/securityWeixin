package com.Riven.ssm.service;

import java.util.List;

import com.Riven.ssm.po.WeixinUser;

public interface WeixinUserService {
	//根据用户openid查询用户信息
	public WeixinUser findWeixinUserByOpenid(String openid) throws Exception;
	//查询所有用户信息
	public List<WeixinUser> findWeixinUserList() throws Exception;
	//新增微信用户,用户存在则更新信息
	public boolean insertOrUpdateWeixinUser(WeixinUser weixinUser) throws Exception;
	//更新微信用户
	public boolean updateWeixinUser(WeixinUser weixinUser) throws Exception;
	//根据用户openid删除用户
	public boolean deleteWeixinUserByOpenid(String openid) throws Exception;
	
	//根据用户openid设置用户为管理员
	public boolean setAdminByOpenid(String openid) throws Exception;
	//根据用户openid取消用户管理员身份
	public boolean cancelAdminByOpenid(String openid) throws Exception;
	
	
	
}
