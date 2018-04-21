package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.WeixinUser;
import com.Riven.ssm.po.WeixinUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeixinUserMapper {
    int countByExample(WeixinUserExample example);

    int deleteByExample(WeixinUserExample example);

    int deleteByPrimaryKey(String openid);

    int insert(WeixinUser record);

    int insertSelective(WeixinUser record);

    List<WeixinUser> selectByExample(WeixinUserExample example);

    WeixinUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    int updateByExample(@Param("record") WeixinUser record, @Param("example") WeixinUserExample example);

    int updateByPrimaryKeySelective(WeixinUser record);

    int updateByPrimaryKey(WeixinUser record);
}