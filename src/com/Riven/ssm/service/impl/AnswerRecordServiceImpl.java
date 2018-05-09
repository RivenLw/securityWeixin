package com.Riven.ssm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.Riven.ssm.dao.mapper.AnswerRecordMapper;
import com.Riven.ssm.po.AnswerRecord;
import com.Riven.ssm.po.AnswerRecordExample;
import com.Riven.ssm.service.AnswerRecordService;

public class AnswerRecordServiceImpl implements AnswerRecordService {

	@Autowired
	AnswerRecordMapper answerRecordMapper;
	
	@Override
	public AnswerRecord findAnswerRecordById(Integer recordid) throws Exception {
		// TODO Auto-generated method stub
		return answerRecordMapper.selectByPrimaryKey(recordid);
	}

	@Override
	public List<AnswerRecord> findAnswerRecordList() throws Exception {
		// TODO Auto-generated method stub
		return answerRecordMapper.selectByExample(null);
	}

	@Override
	public boolean insertAnswerRecord(AnswerRecord answerRecord) throws Exception {
		int result = answerRecordMapper.insertSelective(answerRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteAnswerRecordById(Integer recordid) throws Exception {
		AnswerRecord answerRecord = new AnswerRecord();
		answerRecord.setRecordId(recordid);
		answerRecord.setRecordStatus("已删除");
		
		int result = answerRecordMapper.updateByPrimaryKeySelective(answerRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean updateAnswerRecord(AnswerRecord answerRecord) throws Exception {
		// TODO Auto-generated method stub
		int result = answerRecordMapper.updateByPrimaryKey(answerRecord);
		if (result==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<AnswerRecord> findAnswerRecordByOpenid(String openid) throws Exception {
		// TODO Auto-generated method stub
		AnswerRecordExample answerRecordExample = new AnswerRecordExample();
		AnswerRecordExample.Criteria criteria = answerRecordExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		
		answerRecordExample.setOrderByClause("START_TIME desc");
		
		return answerRecordMapper.selectByExample(answerRecordExample);
	}

	//根据openid获取到记录中的错题，返回错题编号的set
	@Override
	public Set<String> findWrongQuesByOpenid(String openid) throws Exception {
		AnswerRecordExample answerRecordExample = new AnswerRecordExample();
		AnswerRecordExample.Criteria criteria = answerRecordExample.createCriteria();
		criteria.andOpenidEqualTo(openid);
		
		
		List<AnswerRecord> answerRecords = answerRecordMapper.selectByExample(answerRecordExample);
		
		Set<String> wrongQuess = new HashSet<String>();
		
		for (AnswerRecord answerRecord : answerRecords) {
			String allFalseQuesStr= answerRecord.getFalseQuestion();
			if (allFalseQuesStr!=null) {
				allFalseQuesStr = allFalseQuesStr.substring(0, allFalseQuesStr.length()-1);
				String[] falseQuess = allFalseQuesStr.split(",");
				
				for (String quesId : falseQuess) {
					wrongQuess.add(quesId);
				}
				
			}
			
		}
		
		return wrongQuess;
	}

}
