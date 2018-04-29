package com.Riven.ssm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Riven.ssm.po.WeixinUser;
import com.Riven.ssm.service.WechatService;
import com.Riven.ssm.service.WeixinUserService;
import com.Riven.ssm.util.ValidationUtil;
import com.Riven.ssm.util.WechatUtil;

@Controller
@RequestMapping("/wechat")
public class WeixinAction {

	private static final String TOKEN = "123qwe";

	private static final Logger LOGGER = LoggerFactory.getLogger(WeixinAction.class);

	@Autowired
	WechatService wechatService;
	@Autowired
	WeixinUserService weixinUserService;

	/**
	 * 微信接入
	 * 
	 * @param 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/connect", method = { RequestMethod.GET, RequestMethod.POST })
	public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8"); // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		response.setCharacterEncoding("UTF-8"); // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		boolean isGet = request.getMethod().toLowerCase().equals("get");

		PrintWriter out = response.getWriter();

		try {
			if (isGet) {
				String signature = request.getParameter("signature");// 微信加密签名
				String timestamp = request.getParameter("timestamp");// 时间戳
				String nonce = request.getParameter("nonce");// 随机数
				String echostr = request.getParameter("echostr");// 随机字符串

				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (ValidationUtil.checkSignature(signature, timestamp, nonce)) {
					LOGGER.info("Connect the weixin server is successful.");
					response.getWriter().write(echostr);
				} else {
					response.getWriter().write(echostr);
					LOGGER.error("Failed to verify the signature!");
				}
			} else {
				String respMessage = "异常消息！";

				try {
					respMessage = wechatService.weixinPost(request);
					out.write(respMessage);
					LOGGER.info("The request completed successfully");
					LOGGER.info("to weixin server " + respMessage);
				} catch (Exception e) {
					LOGGER.error("Failed to convert the message from weixin!");
				}

			}
		} catch (Exception e) {
			LOGGER.error("Connect the weixin server is error.");
		} finally {
			out.close();
		}
	}
	
	/**
	 * 获取微信用户信息存入session后跳转到添加题目页面
	 * @param model
	 * @param code
	 * @param state
	 * @return
	 */
	@RequestMapping("/addquestion")
	public String goAddQuestion(Model model,String code,String state,HttpSession session){
		WechatUtil wechatUtil = new WechatUtil();
		WeixinUser loginUser= wechatUtil.getWeixinUser(code, state);
		LOGGER.info("已获取到昵称为：\""+loginUser.getNickname()+"\"的用户信息");
		System.out.println(loginUser);
		
		try {
			weixinUserService.insertOrUpdateWeixinUser(loginUser);
			session.setAttribute("loginUser", loginUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "addquestion";
	}
	
	/**
	 * 用户点击菜单后并授权后，进入此action，通过code获取到用户信息后，到数据库找该用户是否有管理员权限，
	 * 没有权限则跳转到没有权限的界面提示用户
	 * 有权限则跳转到管理员菜单
	 * @param model
	 * @param code
	 * @param state
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginForAdmin")
	public String loginForAdmin(Model model,String code,String state,HttpSession session){
		//通过code获取用户信息
		WechatUtil wechatUtil = new WechatUtil();
		WeixinUser loginUser= wechatUtil.getWeixinUser(code, state);
		LOGGER.info("已获取到昵称为：\""+loginUser.getNickname()+"\"的用户信息");
		System.out.println(loginUser);
		
		//根据openid查询是否有管理员权限
		try {
			WeixinUser resultUser = weixinUserService.findWeixinUserByOpenid(loginUser.getOpenid());
			
			if (resultUser!=null) {
				if (resultUser.getAdmin().equals("1")) {//有管理员权限
					loginUser.setAdmin("1");
					weixinUserService.insertOrUpdateWeixinUser(loginUser);
					session.setAttribute("loginUser", loginUser);
					return "adminMenu";
				} else {//没有管理员权限
					weixinUserService.insertOrUpdateWeixinUser(loginUser);
					return "noAdmin";
				}
			} else {//数据库中找不到此用户
				weixinUserService.insertOrUpdateWeixinUser(loginUser);
				return "noAdmin";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "noAdmin";
		}
		
	}

}
