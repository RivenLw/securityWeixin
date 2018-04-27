package com.Riven.ssm.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Riven.ssm.action.WeixinAction;
import com.Riven.ssm.po.TextMessage;
import com.Riven.ssm.service.WechatService;
import com.Riven.ssm.util.MessageUtil;
import com.Riven.ssm.util.TulingUtil;

public class WechatServiceImpl implements WechatService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WechatServiceImpl.class);

	@Override
	public String weixinPost(HttpServletRequest request) {

		String respMessage = null;
		try {

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.xmlToMap(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");

			LOGGER.info(
					"FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				//这里根据消息内容添加自定义回复
				if (content.equals("xxx")) {

				}else {
					// 图灵机器人回复自动回复
					
					TulingUtil tulingUtil = new TulingUtil();
					
					String resultStr = tulingUtil.sendMessage(content);
					
					TextMessage text = new TextMessage();
					text.setContent(resultStr);//图灵机器人回复的消息转发给微信用户
					text.setToUserName(fromUserName);
					text.setFromUserName(toUserName);
					text.setCreateTime(new Date().getTime() + "");
					text.setMsgType(msgType);
					
					respMessage = MessageUtil.textMessageToXml(text);
				}


			}
			// 语音消息
			else if (msgType.equals("voice")) {
				TextMessage text = new TextMessage();
				text.setContent("非常抱歉，此公众号有点耳背，暂时不接受语音消息");
				text.setToUserName(fromUserName);
				text.setFromUserName(toUserName);
				text.setCreateTime(new Date().getTime() + "");
				text.setMsgType("text");

				respMessage = MessageUtil.textMessageToXml(text);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");// 事件类型
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {

					TextMessage text = new TextMessage();
					text.setContent("欢迎关注，这是李文的微信公众号测试账号，我是图灵机器人艾达。");
					text.setToUserName(fromUserName);
					text.setFromUserName(toUserName);
					text.setCreateTime(new Date().getTime() + "");
					text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

					respMessage = MessageUtil.textMessageToXml(text);
				}
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅

				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					if (eventKey.equals("customer_telephone")) {
						
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("error......");
			e.printStackTrace();
		}
		return respMessage;
	}

}
