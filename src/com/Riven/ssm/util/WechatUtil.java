package com.Riven.ssm.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.Riven.ssm.po.WeixinUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import sun.misc.BASE64Decoder;

public class WechatUtil {
	
	private String APPID = "wxf0f2852eaf26ce5b";
	private String APPSECRET = "cf3eb017f63e133d55affb0af9bce60b";
	
	public WeixinUser getWeixinUser(String code,String state){
		
		Map<String, String> resultMap = getUserInfoAccessToken(code);
		
		return getUserInfo(resultMap.get("access_token"), resultMap.get("openid"));
	}
	
	/**
     * 获取请求用户信息的access_token
     *
     * @param code
     * @return
     */
    private Map<String, String> getUserInfoAccessToken(String code) {
        Map<String, String> mapobject = null;
        Map<String, String> data = new HashMap();
        try {
            String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                                       APPID, APPSECRET, code);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String tokens = EntityUtils.toString(httpEntity, "utf-8");
            JSONObject jsonObject = new JSONObject();
            mapobject = (Map<String, String>) jsonObject.toJavaObject(JSON.parseObject(tokens), Object.class);
            data.put("openid", mapobject.get("openid").toString().replaceAll("\"", ""));
            data.put("access_token", mapobject.get("access_token").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return data;
    }
    
    
    /**
     * 获取用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    private WeixinUser getUserInfo(String accessToken, String openId) {
        Map<String, String> data = new HashMap();
        WeixinUser weixinUser = null;
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "utf-8");
            JSONObject jsonObject = new JSONObject();
            weixinUser = jsonObject.toJavaObject(JSON.parseObject(response), WeixinUser.class);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return weixinUser;
    }
    
    
	
}
