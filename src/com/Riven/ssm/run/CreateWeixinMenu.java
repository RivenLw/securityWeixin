package com.Riven.ssm.run;

import java.util.ArrayList;
import java.util.List;

import org.weixin4j.Configuration;
import org.weixin4j.Menu;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.OAuthToken;
import org.weixin4j.menu.SingleButton;
import org.weixin4j.menu.ViewButton;

import com.Riven.ssm.util.Peizhi;
import com.alibaba.fastjson.JSONObject;

public class CreateWeixinMenu {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		//所有按钮的根，要放入menu类
		List<SingleButton> rootButtons = new ArrayList<SingleButton>();
		//第一个父菜单
		ViewButton one_Button = new ViewButton("百度一下", "https://www.baidu.com/");
		rootButtons.add(one_Button);
		//第二个父菜单
		/*SingleButton twoButton = new SingleButton("B站");
			//第二个父菜单的子菜单的根
			List<SingleButton> two_subrootButtons = new ArrayList<SingleButton>();
				//第二个父菜单的第一个子菜单
				ViewButton two_onesubButton = new ViewButton("哔哩哔哩", "https://www.bilibili.com/");
				two_subrootButtons.add(two_onesubButton);
			twoButton.setSubButton(two_subrootButtons);
		
		rootButtons.add(twoButton);*/
		//第三个父菜单
		SingleButton threeButton = new SingleButton("我的");
			//第三个父菜单的子菜单的根
			List<SingleButton> three_subrootButtons = new ArrayList<SingleButton>();
				//第三个父菜单的第一个子菜单
				ViewButton three_onesubButton = new ViewButton("管理", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0f2852eaf26ce5b&redirect_uri=http://"+Peizhi.waiUrl+"/securityWeixin/wechat/loginForAdmin.action&response_type=code&scope=snsapi_userinfo&state=xxxx_state#wechat_redirect");
				three_subrootButtons.add(three_onesubButton);
				//第三个父菜单的第二个子菜单
				ViewButton three_twosubButton = new ViewButton("开始答题", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0f2852eaf26ce5b&redirect_uri=http://"+Peizhi.waiUrl+"/securityWeixin/wechat/answerStart.action&response_type=code&scope=snsapi_userinfo&state=xxxx_state#wechat_redirect");
				three_subrootButtons.add(three_twosubButton);
				//第三个父菜单的第三个子菜单
				ViewButton three_threesubButton = new ViewButton("答题记录", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0f2852eaf26ce5b&redirect_uri=http://"+Peizhi.waiUrl+"/securityWeixin/answerRecord/lookAllAnswerRecord.action&response_type=code&scope=snsapi_userinfo&state=xxxx_state#wechat_redirect");
				three_subrootButtons.add(three_threesubButton);
				//第三个父菜单的第四个子菜单
				ViewButton three_foursubButton = new ViewButton("错题集", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf0f2852eaf26ce5b&redirect_uri=http://"+Peizhi.waiUrl+"/securityWeixin/answerRecord/lookwrongques.action&response_type=code&scope=snsapi_userinfo&state=xxxx_state#wechat_redirect");
				three_subrootButtons.add(three_foursubButton);
				//第三个父菜单的第五个子菜单
				ViewButton three_fivesubButton = new ViewButton("我要举报", "http://"+Peizhi.waiUrl+"/securityWeixin/jubao/addjubao.action");
				three_subrootButtons.add(three_fivesubButton);
			threeButton.setSubButton(three_subrootButtons);
		rootButtons.add(threeButton);
		
		menu.setButton(rootButtons);
		
		JSONObject jsonObject = menu.toJSONObject();
		
		System.out.println(jsonObject.toJSONString());
		
		//提交菜单json到微信服务器
		try {
			Weixin weixin = new Weixin();
			OAuthToken authToken = weixin.login(Configuration.getOAuthAppId(), Configuration.getOAuthSecret());
			weixin.createMenu(menu);
			System.out.println(authToken.getAccess_token());
		} catch (WeixinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
