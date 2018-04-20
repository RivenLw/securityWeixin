package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.TorfQuestion;

public interface TorfQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(TorfQuestion record);

    int insertSelective(TorfQuestion record);

    TorfQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(TorfQuestion record);

    int updateByPrimaryKey(TorfQuestion record);
}