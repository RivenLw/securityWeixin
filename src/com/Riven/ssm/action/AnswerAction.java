package com.Riven.ssm.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.AnswerRecord;
import com.Riven.ssm.service.AnswerRecordService;

@Controller
@RequestMapping("/answer")
public class AnswerAction {
	
	@Autowired
	AnswerRecordService answerRecordService;
	
	/**
	 * 获取答题记录信息，存入数据库
	 * @param answerRecord
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveAnswerRecord")
	public @ResponseBody String saveAnswerRecord(@RequestBody AnswerRecord answerRecord,Model model){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endTime = simpleDateFormat.format(new Date());
		
		answerRecord.setEndTime(endTime);
		answerRecord.setAnswerStatus("已完成");
		
		try {
			boolean flag = answerRecordService.insertAnswerRecord(answerRecord);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		
	}

}
