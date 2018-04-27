package com.Riven.ssm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.ChoiceQuestion;
import com.Riven.ssm.po.TorfQuestion;
import com.Riven.ssm.service.ChoiceQuestionService;
import com.Riven.ssm.service.TorfQuestionService;

@Controller
@RequestMapping("/question")
public class QuestionAction {

	@Autowired
	ChoiceQuestionService choiceQuestionService;
	@Autowired
	TorfQuestionService torfQuestionService;

	@RequestMapping("/addquestion")
	public String addQuestion(Model model) {
		return "addquestion";
	}

	@RequestMapping("/savechoicequestion")
	public @ResponseBody String saveChoiceQuestion(@RequestBody ChoiceQuestion question) {

		try {
			boolean flag = choiceQuestionService.insertChoiceQuestion(question);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}

	}

	@RequestMapping("/savetorfquestion")
	public @ResponseBody String saveTorfQuestion(@RequestBody TorfQuestion torfQuestion) {

		try {
			boolean flag = torfQuestionService.insertTorfQuestion(torfQuestion);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}

	}
	
	@RequestMapping("/lookquestion")
	public String getAllQuestion(Model model) {//题目管理
		
		try {
			List<ChoiceQuestion> choList = choiceQuestionService.findChoiceQuestionList();
			List<TorfQuestion> torfList = torfQuestionService.findTorfQuestionList();
			
			model.addAttribute("choList", choList);
			model.addAttribute("torfList", torfList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "lookquestion";
	}
	
	@RequestMapping("/editxzquestion")
	public String editxzquestion(String questionId,Model model){//根据传来的ID获取到题目后，跳转到编辑选择题的页面
		
		try {
			ChoiceQuestion editxzquestion = choiceQuestionService.findChoiceQuestionById(questionId);
			System.out.println(editxzquestion);
			model.addAttribute("editxzquestion", editxzquestion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "editxzquestion";
	}
	

}
