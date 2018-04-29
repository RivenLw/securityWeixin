package com.Riven.ssm.action;

import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String addQuestion(Model model) {//跳转到添加题目界面
		return "addquestion";
	}

	@RequestMapping("/savechoicequestion")
	public @ResponseBody String saveChoiceQuestion(@RequestBody ChoiceQuestion question) {//保存选择题

		try {
			boolean flag = choiceQuestionService.insertChoiceQuestion(question);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}

	}

	@RequestMapping("/updatachoicequestion")
	public @ResponseBody String updatachoicequestion(@RequestBody ChoiceQuestion question) {//修改选择题
		
		try {
			boolean flag = choiceQuestionService.updateChoiceQuestion(question);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "false";
		}
		
	}
	@RequestMapping("/savetorfquestion")
	public @ResponseBody String saveTorfQuestion(@RequestBody TorfQuestion torfQuestion) {//保存判断题

		try {
			boolean flag = torfQuestionService.insertTorfQuestion(torfQuestion);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}

	}
	
	@RequestMapping("/updatatorfquestion")
	public @ResponseBody String updatatorfquestion(@RequestBody TorfQuestion torfQuestion) {//修改判断题
		
		try {
			boolean flag = torfQuestionService.updateTorfQuestion(torfQuestion);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "false";
		}
		
	}
	@RequestMapping("/lookquestion")
	public String getAllQuestion(Model model) {//跳转题目管理页面
		
		try {
			List<ChoiceQuestion> choList = choiceQuestionService.findChoiceQuestionList();
			List<TorfQuestion> torfList = torfQuestionService.findTorfQuestionList();
			
			model.addAttribute("choList", choList);
			model.addAttribute("torfList", torfList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
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
			return "error";
		}
		
		return "editxzquestion";
	}
	
	@RequestMapping("/editpdquestion")
	public String editpdquestion(String questionId,Model model){//根据传来的ID获取到题目后，跳转到编辑判断题的页面
		
		try {
			TorfQuestion editpdquestion = torfQuestionService.findTorfQuestionById(questionId);
			System.out.println(editpdquestion);
			model.addAttribute("editpdquestion", editpdquestion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "editpdquestion";
	}
	@RequestMapping(value = "/deletechoicequestion", method = { RequestMethod.POST })
	public @ResponseBody String deletechoicequestion(@RequestBody ChoiceQuestion question,Model model){//根据传来的ID删除题目
		
		try {
			boolean flag = choiceQuestionService.deleteChoiceQuestionById(question.getQuestionId());
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}
		
	}

	@RequestMapping(value = "/deletetorfquestion", method = { RequestMethod.POST })
	public @ResponseBody String deletetorfquestion(@RequestBody TorfQuestion question,Model model){//根据传来的ID删除题目
		
		try {
			boolean flag = torfQuestionService.deleteTorfQuestionById(question.getQuestionId());
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "false";
		}
		
	}
}
