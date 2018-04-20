package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.WeixinUser;

public interface WeixinUserMapper {
    int deleteByPrimaryKey(String openid);

    int insert(WeixinUser record);

    int insertSelective(WeixinUser record);

    WeixinUser selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(WeixinUser record);

    int updateByPrimaryKey(WeixinUser record);
}