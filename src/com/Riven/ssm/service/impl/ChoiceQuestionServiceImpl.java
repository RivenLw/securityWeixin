package com.Riven.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.ChoiceQuestionMapper;
import com.Riven.ssm.po.ChoiceQuestion;
import com.Riven.ssm.po.ChoiceQuestionExample;
import com.Riven.ssm.service.ChoiceQuestionService;

public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

	@Autowired
	ChoiceQuestionMapper choiceQuestionMapper;
	
	@Override
	public boolean insertChoiceQuestion(ChoiceQuestion choiceQuestion) throws Exception {
		// TODO Auto-generated method stub
		int result = choiceQuestionMapper.insertSelective(choiceQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteChoiceQuestionById(String id) throws Exception {
		// TODO Auto-generated method stub
		ChoiceQuestion choiceQuestion = new ChoiceQuestion();
		choiceQuestion.setQuestionId(id);
		choiceQuestion.setIsdelete("已删除");
		
		int result = choiceQuestionMapper.updateByPrimaryKeySelective(choiceQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateChoiceQuestion(ChoiceQuestion choiceQuestion) throws Exception {
		// TODO Auto-generated method stub
		int result = choiceQuestionMapper.updateByPrimaryKey(choiceQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ChoiceQuestion findChoiceQuestionById(String id) throws Exception {
		// TODO Auto-generated method stub
		return choiceQuestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ChoiceQuestion> findChoiceQuestionList() throws Exception {
		// TODO Auto-generated method stub
		return choiceQuestionMapper.selectByExample(null);
	}

	@Override
	public List<ChoiceQuestion> findChoiceQuestionByIdArray(ArrayList<String> idStrings) throws Exception {
		// TODO Auto-generated method stub
		ChoiceQuestionExample choiceQuestionExample = new ChoiceQuestionExample();
		ChoiceQuestionExample.Criteria criteria = choiceQuestionExample.createCriteria();
		criteria.andQuestionIdIn(idStrings);
		
		return choiceQuestionMapper.selectByExample(choiceQuestionExample);
	}

}
