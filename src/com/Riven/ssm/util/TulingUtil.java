package com.Riven.ssm.util;



import com.Riven.ssm.tuling.InputText;
import com.Riven.ssm.tuling.Perception;
import com.Riven.ssm.tuling.ReqMsgPo;
import com.Riven.ssm.tuling.RespMsgPo;
import com.Riven.ssm.tuling.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TulingUtil {

	//访问的key,是每一个用户自己的
	private String apikey = "d91062811227480c97f377dd169a346e";
	
	//接口地址
	private String url = "http://openapi.tuling123.com/openapi/api/v2";
	
	public TulingUtil() {
		super();
	}
	
	public String sendMessage(String sendMsgStr){
		
		ReqMsgPo reqMsgPo = new ReqMsgPo();
		reqMsgPo.setReqType(0);
		Perception perception = new Perception();
		perception.setInputText(new InputText(sendMsgStr));
		reqMsgPo.setPerception(perception);
		UserInfo userInfo = new UserInfo();
		userInfo.setApiKey(apikey);
		userInfo.setUserId("529234213");
		reqMsgPo.setUserInfo(userInfo);
		
		JSONObject jsonObject = new JSONObject();
		String reqJson = jsonObject.toJSONString(reqMsgPo);
		
		//发送数据
		String respJson  = HttpClientUtils.postJson(this.url,reqJson);
		
		RespMsgPo respMsgPo =jsonObject.toJavaObject(JSON.parseObject(respJson), RespMsgPo.class);//JsonUtils.json2Object(respJson, RespMsgPo.class);
		//System.out.println(json);
		//将json数据转化为object
		int respCode = respMsgPo.getIntent().getCode();
		String resultValue = "图灵机器人宕机了";
		
			String resultType = respMsgPo.getResults().get(0).getResultType();
			resultValue = respMsgPo.getResults().get(0).getValues().get(resultType);
		
		return resultValue;
	}
	
}
