package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.JubaoRecord;
import com.Riven.ssm.po.JubaoRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JubaoRecordMapper {
    int countByExample(JubaoRecordExample example);

    int deleteByExample(JubaoRecordExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(JubaoRecord record);

    int insertSelective(JubaoRecord record);

    List<JubaoRecord> selectByExample(JubaoRecordExample example);

    JubaoRecord selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") JubaoRecord record, @Param("example") JubaoRecordExample example);

    int updateByExample(@Param("record") JubaoRecord record, @Param("example") JubaoRecordExample example);

    int updateByPrimaryKeySelective(JubaoRecord record);

    int updateByPrimaryKey(JubaoRecord record);
}