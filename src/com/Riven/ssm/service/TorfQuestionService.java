package com.Riven.ssm.service;

import java.util.List;

import com.Riven.ssm.po.TorfQuestion;

public interface TorfQuestionService {

	//新增判断题
	public boolean insertTorfQuestion(TorfQuestion torfQuestion) throws Exception;
	//删除判断题
	public boolean deleteTorfQuestionById(String id) throws Exception;
	//修改判断题
	public boolean updateTorfQuestion(TorfQuestion torfQuestion) throws Exception;
	//根据id查询判断题
	public TorfQuestion findTorfQuestionById(String id) throws Exception;
	//查询所有判断题
	public List<TorfQuestion> findTorfQuestionList() throws Exception;
	//根据id数组查询判断题
	public List<TorfQuestion> findTorfQuestionByIdList(List<String> idStrings) throws Exception;
	//查询没有被删除的判断题
	public List<TorfQuestion> findTorfQuestionNoDelete() throws Exception;
	
}
