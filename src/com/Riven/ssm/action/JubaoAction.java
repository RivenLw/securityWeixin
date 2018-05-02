package com.Riven.ssm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.JubaoRecord;
import com.Riven.ssm.service.JubaoRecordServicer;

@Controller
@RequestMapping("/jubao")
public class JubaoAction {
	
	@Autowired
	JubaoRecordServicer jubaoRecordServicer;

	@RequestMapping("/addjubao")
	public String goAddjubaoJSP(){
		return "addjubao";
	}
	
	@RequestMapping("/savejubao")
	public @ResponseBody String saveJubao(@RequestBody JubaoRecord jubaoRecord){
		
		try {
			boolean flag = jubaoRecordServicer.insertJubaoRecord(jubaoRecord);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}
	}
	
	@RequestMapping("/lookalljubaorecord")
	public String lookAllJubaoRecord(Model model){
		
		try {
			List<JubaoRecord> jubaolist = jubaoRecordServicer.findJubaoRecordList();
			
			model.addAttribute("jubaolist", jubaolist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "lookalljubao";
	}
	
	@RequestMapping("/lookonejubao")
	public String lookonejubao(Integer recordid,Model model){
		
		try {
			JubaoRecord jubaoRecord = jubaoRecordServicer.findJubaoRecoedById(recordid);
			
			model.addAttribute("jubaoRecord", jubaoRecord);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "lookonejubao";
	}
	
}
