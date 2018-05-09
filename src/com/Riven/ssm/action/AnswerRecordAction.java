package com.Riven.ssm.action;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Riven.ssm.po.AnswerRecord;
import com.Riven.ssm.po.AnswerRecordExt;
import com.Riven.ssm.po.ChoiceQuestion;
import com.Riven.ssm.po.TorfQuestion;
import com.Riven.ssm.po.WeixinUser;
import com.Riven.ssm.service.AnswerRecordService;
import com.Riven.ssm.service.ChoiceQuestionService;
import com.Riven.ssm.service.TorfQuestionService;
import com.Riven.ssm.service.WeixinUserService;
import com.Riven.ssm.util.WechatUtil;

@Controller
@RequestMapping("/answerRecord")
public class AnswerRecordAction {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnswerRecordAction.class);

	@Autowired
	AnswerRecordService answerRecordService;
	@Autowired
	WeixinUserService weixinUserService;
	@Autowired
	ChoiceQuestionService choiceQuestionService;
	@Autowired
	TorfQuestionService torfQuestionService;
	
	//获取用户的所有答题记录后跳转到对应界面
	@RequestMapping("/lookAllAnswerRecord")
	public String lookAllAnswerRecord(Model model,String code,String state,HttpSession session){
		//通过code获取用户信息
		WechatUtil wechatUtil = new WechatUtil();
		WeixinUser loginUser= wechatUtil.getWeixinUser(code, state);
		LOGGER.info("已获取到昵称为：\""+loginUser.getNickname()+"\"的用户信息");
		System.out.println(loginUser);
		

		try {
			weixinUserService.insertOrUpdateWeixinUser(loginUser);
			session.setAttribute("loginUser", loginUser);
			
			List<AnswerRecord> resultRecords = answerRecordService.findAnswerRecordByOpenid(loginUser.getOpenid());
			
			List<AnswerRecordExt> recordExts = new ArrayList<AnswerRecordExt>();
			
			for (AnswerRecord answerRecord : resultRecords) {
				AnswerRecordExt recordExt = new AnswerRecordExt();
				recordExt.setRecordId(answerRecord.getRecordId());
				recordExt.setOpenid(answerRecord.getOpenid());
				recordExt.setStartTime(answerRecord.getStartTime());
				recordExt.setEndTime(answerRecord.getEndTime());
				recordExt.setQuestionSum(answerRecord.getQuestionSum());
				recordExt.setTrueQuestions(answerRecord.getTrueQuestions());
				recordExt.setFalseQuestion(answerRecord.getFalseQuestion());
				recordExt.setNickname(answerRecord.getNickname());
				
				String startTime = answerRecord.getStartTime();
				String endTime = answerRecord.getEndTime();
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate = simpleDateFormat.parse(startTime);
				Date endDate = simpleDateFormat.parse(endTime);
				
				long l=endDate.getTime()-startDate.getTime();
				long day=l/(24*60*60*1000);
				long hour=(l/(60*60*1000)-day*24);
				long min=((l/(60*1000))-day*24*60-hour*60);
				long s=(l/1000-day*24*60*60-hour*60*60-min*60);
				System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
				
				String useTime = ""+min+"分"+s+"秒";
				recordExt.setUseTime(useTime);
				
				String trueQstr = answerRecord.getTrueQuestions();
				String falseQstr = answerRecord.getFalseQuestion();
				
				int trueQstrsize = 0;
				
				if (trueQstr!=null) {
					recordExt.setTruelist(Arrays.asList(trueQstr.substring(0, answerRecord.getTrueQuestions().length()-1).split(",")));
					trueQstrsize = recordExt.getTruelist().size();
				}
				if (falseQstr!=null) {
					recordExt.setFalselist(Arrays.asList(falseQstr.substring(0, answerRecord.getFalseQuestion().length()-1).split(",")));
				}
				
				DecimalFormat df = new DecimalFormat("0.0");//格式化小数    
		        String zhengquelv = df.format((float)(trueQstrsize*100)/Integer.parseInt(recordExt.getQuestionSum()));//返回的是String类型    
				
		        recordExt.setZhengquelv(zhengquelv);
		        
		        recordExts.add(recordExt);
		        
			}
			
			model.addAttribute("recordExts", recordExts);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		
		return "lookAllAnswerRecord";
	}
	
	//错题集查看
	@RequestMapping("/lookwrongques")
	public String lookwrongques(Model model,String code,String state,HttpSession session){
		WeixinUser loginUser = null;
		WeixinUser oldUser = (WeixinUser) session.getAttribute("loginUser");
		if (oldUser!=null) {
			loginUser = oldUser;
		} else {
			//通过code获取用户信息
			WechatUtil wechatUtil = new WechatUtil();
			loginUser= wechatUtil.getWeixinUser(code, state);
			LOGGER.info("已获取到昵称为：\""+loginUser.getNickname()+"\"的用户信息");
			System.out.println(loginUser);
			session.setAttribute("loginUser", loginUser);
		}
		
		try {
			Set<String>allwrongquess = answerRecordService.findWrongQuesByOpenid(loginUser.getOpenid());
			
			List<ChoiceQuestion> choList = new ArrayList<ChoiceQuestion>();
			List<TorfQuestion> torfList = new ArrayList<TorfQuestion>();
			//根据题目编号获取到题目的信息后存入对应list中
			for (String quesId : allwrongquess) {
				String quesType = quesId.substring(0, 2);
				if ("XZ".equals(quesType)) {
					choList.add(choiceQuestionService.findChoiceQuestionById(quesId));
				} else {
					torfList.add(torfQuestionService.findTorfQuestionById(quesId));
				}
				
			}
			
			model.addAttribute("choList", choList);
			model.addAttribute("torfList", torfList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "lookwrongques";
	}
	
}
