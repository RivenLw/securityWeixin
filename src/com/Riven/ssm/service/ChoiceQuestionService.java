package com.Riven.ssm.service;

import java.util.ArrayList;
import java.util.List;

import com.Riven.ssm.po.ChoiceQuestion;

public interface ChoiceQuestionService {

	//新增选择题
	public boolean insertChoiceQuestion(ChoiceQuestion choiceQuestion) throws Exception;
	//删除选择题
	public boolean deleteChoiceQuestionById(String id) throws Exception;
	//修改选择题
	public boolean updateChoiceQuestion(ChoiceQuestion choiceQuestion) throws Exception;
	//根据id查询选择题
	public ChoiceQuestion findChoiceQuestionById(String id) throws Exception;
	//查询所有选择题
	public List<ChoiceQuestion> findChoiceQuestionList() throws Exception;
	//根据id数据查询对应选择题
	public List<ChoiceQuestion> findChoiceQuestionByIdArray(ArrayList<String> idStrings) throws Exception;
	
}
