package com.zh.model;

public class Tools {
	//提供一个方法 将乱码转成gbk gb2312 utf-8
	public static String getNewString(String input){
		String result = "";
		try {
			result = new String(input.getBytes("iso-8859-1"),"gbk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
