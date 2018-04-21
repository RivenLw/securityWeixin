package com.Riven.ssm.dao.mapper;

import com.Riven.ssm.po.TorfQuestion;
import com.Riven.ssm.po.TorfQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TorfQuestionMapper {
    int countByExample(TorfQuestionExample example);

    int deleteByExample(TorfQuestionExample example);

    int deleteByPrimaryKey(String questionId);

    int insert(TorfQuestion record);

    int insertSelective(TorfQuestion record);

    List<TorfQuestion> selectByExample(TorfQuestionExample example);

    TorfQuestion selectByPrimaryKey(String questionId);

    int updateByExampleSelective(@Param("record") TorfQuestion record, @Param("example") TorfQuestionExample example);

    int updateByExample(@Param("record") TorfQuestion record, @Param("example") TorfQuestionExample example);

    int updateByPrimaryKeySelective(TorfQuestion record);

    int updateByPrimaryKey(TorfQuestion record);
}