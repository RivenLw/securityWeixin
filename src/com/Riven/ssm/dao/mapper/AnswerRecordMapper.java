package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.AnswerRecord;

public interface AnswerRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(AnswerRecord record);

    int insertSelective(AnswerRecord record);

    AnswerRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(AnswerRecord record);

    int updateByPrimaryKey(AnswerRecord record);
}