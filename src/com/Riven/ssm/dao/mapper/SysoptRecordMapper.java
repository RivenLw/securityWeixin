package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.SysoptRecord;
import com.Riven.ssm.po.SysoptRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysoptRecordMapper {
    int countByExample(SysoptRecordExample example);

    int deleteByExample(SysoptRecordExample example);

    int deleteByPrimaryKey(Integer operationId);

    int insert(SysoptRecord record);

    int insertSelective(SysoptRecord record);

    List<SysoptRecord> selectByExample(SysoptRecordExample example);

    SysoptRecord selectByPrimaryKey(Integer operationId);

    int updateByExampleSelective(@Param("record") SysoptRecord record, @Param("example") SysoptRecordExample example);

    int updateByExample(@Param("record") SysoptRecord record, @Param("example") SysoptRecordExample example);

    int updateByPrimaryKeySelective(SysoptRecord record);

    int updateByPrimaryKey(SysoptRecord record);
}