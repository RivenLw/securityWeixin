package com.Riven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.TorfQuestionMapper;
import com.Riven.ssm.po.TorfQuestion;
import com.Riven.ssm.po.TorfQuestionExample;
import com.Riven.ssm.service.TorfQuestionService;

public class TorfQuestionServiceImpl implements TorfQuestionService {

	@Autowired
	TorfQuestionMapper torfQuestionMapper;
	
	@Override
	public boolean insertTorfQuestion(TorfQuestion torfQuestion) throws Exception {
		// TODO Auto-generated method stub
		int result = torfQuestionMapper.insertSelective(torfQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteTorfQuestionById(String id) throws Exception {
		// TODO Auto-generated method stub
		TorfQuestion torfQuestion = new TorfQuestion();
		torfQuestion.setQuestionId(id);
		torfQuestion.setIsdelete("已删除");
		
		int result = torfQuestionMapper.updateByPrimaryKeySelective(torfQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateTorfQuestion(TorfQuestion torfQuestion) throws Exception {
		// TODO Auto-generated method stub
		int result = torfQuestionMapper.updateByPrimaryKey(torfQuestion);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public TorfQuestion findTorfQuestionById(String id) throws Exception {
		// TODO Auto-generated method stub
		return torfQuestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TorfQuestion> findTorfQuestionList() throws Exception {
		// TODO Auto-generated method stub
		return torfQuestionMapper.selectByExample(null);
	}

	@Override
	public List<TorfQuestion> findTorfQuestionByIdList(List<String> idStrings) throws Exception {
		// TODO Auto-generated method stub
		TorfQuestionExample torfQuestionExample = new TorfQuestionExample();
		TorfQuestionExample.Criteria criteria = torfQuestionExample.createCriteria();
		criteria.andQuestionIdIn(idStrings);
		
		return torfQuestionMapper.selectByExample(torfQuestionExample);
	}

}
