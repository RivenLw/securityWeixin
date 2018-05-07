package com.Riven.ssm.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sun.misc.BASE64Decoder;

public class Base64Util {
	
	//通过base64保存图片，返回保存图片的文件名
	public static String saveImgFromBase64code(String base64code){
		Map<String, String>resultmap = getTypeAndData(base64code);
		String fileType = resultmap.get("type");
		String fileData = resultmap.get("data");
		
		String fileName = getShuByTime()+"."+fileType;
		
		String savePath = "D:\\2018我的\\MeEclipseWorkspaces\\securityWeixin\\WebRoot\\jubaoImg\\"+fileName;
		
		GenerateImage(fileData, savePath);
		
		return fileName;
	} 
	

	/**
	 * 传入编码，返回存有type和能转为图片的数据字符map
	 * @return
	 */
	public static Map<String, String> getTypeAndData(String base64code){
		Map<String, String> returnmap = new HashMap<String, String>();
		
		String[] strings = base64code.split(";");
		String type = strings[0].replaceAll("data:image/", "");
		String data = strings[1].replaceAll("base64,", "");
		
		returnmap.put("type", type);
		returnmap.put("data", data);
		
		return returnmap;
	}
	
	//根据时间获取随机数
	public static String getShuByTime(){
		
		long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
        System.out.println(rd.nextInt());//生成随即整数
		
		return String.valueOf(rd.nextInt());
	}
	
	
	//base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
          return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
          // Base64解码
          byte[] bytes = decoder.decodeBuffer(imgStr);
          for (int i = 0; i < bytes.length; ++i) {
            if (bytes[i] < 0) {// 调整异常数据
              bytes[i] += 256;
            }
          }
          // 生成jpeg图片
          OutputStream out = new FileOutputStream(imgFilePath);
          out.write(bytes);
          out.flush();
          out.close();
          return true;
        } catch (Exception e) {
          return false;
        }
      }
	
}
