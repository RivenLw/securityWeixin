package com.Riven.ssm.action;

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

/*	@RequestMapping("/addquestion")
	public String addQuestion(Model model) {
		return "addquestion";
	}*/

	@RequestMapping("/savechoicequestion")
	public @ResponseBody String saveChoiceQuestion(@RequestBody ChoiceQuestion question) {

		try {
			boolean flag = true;//choiceQuestionService.insertChoiceQuestion(question);
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
			boolean flag = true;//torfQuestionService.insertTorfQuestion(torfQuestion);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}

	}

}
