package com.Riven.ssm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Riven.ssm.dao.mapper.TorfQuestionMapper;
import com.Riven.ssm.po.TorfQuestion;

public class TorfQuestionMapperTest {

	ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[]{
						"spring/applicationContext.xml",
						"spring/applicationContext-dao.xml",
						"spring/applicationContext-service.xml"
				}
				);
		
	}

	@Test
	public void testInsert() {
		TorfQuestion torfQuestion = new TorfQuestion();
		torfQuestion.setQuestionContent("这是一个错的判断题。");
		torfQuestion.setAnswer("false");
		torfQuestion.setSolution("这里是解释这道题为什么是错的。");
		
		TorfQuestionMapper torfQuestionMapper  = (TorfQuestionMapper) applicationContext.getBean("torfQuestionMapper");
		
		int result = torfQuestionMapper.insertSelective(torfQuestion);
		
		System.out.println(result);
		
	}
	
	@Test
	public void testSelectByExample(){
		
		TorfQuestionMapper torfQuestionMapper  = (TorfQuestionMapper) applicationContext.getBean("torfQuestionMapper");
		List<TorfQuestion> torfQuestions = torfQuestionMapper.selectByExample(null);
		
		for (TorfQuestion torfQuestion : torfQuestions) {
			System.out.println(torfQuestion);
		}
		
	}
	

}
