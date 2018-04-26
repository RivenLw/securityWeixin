package com.Riven.ssm.test;

import com.Riven.ssm.util.TulingUtil;

public class TulingTset {

	public static void main(String[] args) {
		
		TulingUtil tulingUtil = new TulingUtil();
		
		String resultStr = tulingUtil.sendMessage("你叫什么名字");
		
		System.out.println(resultStr);
		
	}
	
}
