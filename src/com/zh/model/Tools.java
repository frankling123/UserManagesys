package com.zh.model;

public class Tools {
	//�ṩһ������ ������ת��gbk gb2312 utf-8
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
