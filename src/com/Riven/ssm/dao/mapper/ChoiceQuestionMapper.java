package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.ChoiceQuestion;

public interface ChoiceQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(ChoiceQuestion record);

    int insertSelective(ChoiceQuestion record);

    ChoiceQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
}