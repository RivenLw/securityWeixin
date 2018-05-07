package com.Riven.ssm.action;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.JubaoRecord;
import com.Riven.ssm.service.JubaoRecordServicer;
import com.Riven.ssm.util.Base64Util;

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
			
			
			List<String> base64codes = jubaoRecord.getBase64codes();
			String images = "";
			
			for (String base64code : base64codes) {
				String fileName = Base64Util.saveImgFromBase64code(base64code)+",";
				images+=fileName;
				
				System.out.println(fileName);
			}
			jubaoRecord.setImages(images.substring(0, images.length()-1));
			
			
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
			
			String images = jubaoRecord.getImages();
			if (images!=null) {
				String[] imgStrings = images.split(",");
				jubaoRecord.setImageNames(Arrays.asList(imgStrings));
			}
			
			model.addAttribute("jubaoRecord", jubaoRecord);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

		return "lookonejubao";
	}
	
}
