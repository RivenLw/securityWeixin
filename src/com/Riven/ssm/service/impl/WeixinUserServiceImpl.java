package com.Riven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.WeixinUserMapper;
import com.Riven.ssm.po.WeixinUser;
import com.Riven.ssm.po.WeixinUserExample;
import com.Riven.ssm.service.WeixinUserService;

public class WeixinUserServiceImpl implements WeixinUserService {

	@Autowired
	WeixinUserMapper weixinUserMapper;
	
	@Override
	public WeixinUser findWeixinUserByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		return weixinUserMapper.selectByPrimaryKey(openid);
	}

	@Override
	public List<WeixinUser> findWeixinUserList() throws Exception {
		// TODO Auto-generated method stub
		return weixinUserMapper.selectByExample(null);
	}

	@Override
	public boolean insertOrUpdateWeixinUser(WeixinUser weixinUser) throws Exception {
		// TODO Auto-generated method stub
		WeixinUserExample example = new WeixinUserExample();
		WeixinUserExample.Criteria criteria = example.createCriteria();
		criteria.andOpenidEqualTo(weixinUser.getOpenid());
		
		try {
			//如果有记录则update
			int result = weixinUserMapper.countByExample(example);
			if (result==0) {
				weixinUserMapper.insertSelective(weixinUser);
				return true;
			} else {
				return this.updateWeixinUser(weixinUser);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateWeixinUser(WeixinUser weixinUser) throws Exception {
		// TODO Auto-generated method stub
		int result = weixinUserMapper.updateByPrimaryKeySelective(weixinUser);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteWeixinUserByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		int result = weixinUserMapper.deleteByPrimaryKey(openid);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean setAdminByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		WeixinUser weixinUser = new WeixinUser();
		weixinUser.setOpenid(openid);
		weixinUser.setAdmin("1");

		int result = weixinUserMapper.updateByPrimaryKeySelective(weixinUser);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean cancelAdminByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		WeixinUser weixinUser = new WeixinUser();
		weixinUser.setOpenid(openid);
		weixinUser.setAdmin("0");

		int result = weixinUserMapper.updateByPrimaryKeySelective(weixinUser);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

}
