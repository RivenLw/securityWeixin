package com.Riven.ssm.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.WeixinUser;
import com.Riven.ssm.service.WeixinUserService;

@Controller
@RequestMapping("/admin")
public class AdminAction {
	
	@Autowired
	WeixinUserService weixinUserService;

	//通过数据库获取所有用户后，跳转到管理员管理界面
	@RequestMapping("/goadminmanage")
	public String gotoAdminManage(Model model){
		try {
			List<WeixinUser> allUser = weixinUserService.findWeixinUserList();
			
			model.addAttribute("allUser", allUser);
			
			return "adminManage";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}
	
	//取消管理员
	@RequestMapping("/canceladmin")
	public @ResponseBody String canceladmin(@RequestBody WeixinUser weixinUser){
		
		try {
			weixinUser.setAdmin("0");
			boolean flag = weixinUserService.updateWeixinUser(weixinUser);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "false";
		}
	}
	
	//设为管理员
	@RequestMapping("/setadmin")
	public @ResponseBody String setadmin(@RequestBody WeixinUser weixinUser){
		
		try {
			weixinUser.setAdmin("1");
			boolean flag = weixinUserService.updateWeixinUser(weixinUser);
			return String.valueOf(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "false";
		}
	}
	
}
