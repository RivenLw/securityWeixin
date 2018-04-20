package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.SysoptRecord;

public interface SysoptRecordMapper {
    int deleteByPrimaryKey(Integer operationId);

    int insert(SysoptRecord record);

    int insertSelective(SysoptRecord record);

    SysoptRecord selectByPrimaryKey(Integer operationId);

    int updateByPrimaryKeySelective(SysoptRecord record);

    int updateByPrimaryKey(SysoptRecord record);
}