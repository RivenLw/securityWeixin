package com.Riven.ssm.service;

import java.util.List;
import java.util.Set;

import com.Riven.ssm.po.AnswerRecord;

public interface AnswerRecordService {

	//根据记录id查询记录信息
	public AnswerRecord findAnswerRecordById(Integer recordid) throws Exception;
	//查询所有记录信息
	public List<AnswerRecord> findAnswerRecordList() throws Exception;
	//新增答题记录
	public boolean insertAnswerRecord(AnswerRecord answerRecord) throws Exception;
	//删除答题记录
	public boolean deleteAnswerRecordById(Integer recordid) throws Exception;
	//修改答题记录
	public boolean updateAnswerRecord(AnswerRecord answerRecord) throws Exception;
	//根据openid查询记录
	public List<AnswerRecord> findAnswerRecordByOpenid(String openid) throws Exception;
	//根据openid查询出所有答错过的题目
	public Set<String> findWrongQuesByOpenid(String openid) throws Exception;
}
