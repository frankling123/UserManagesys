//这是一个javabean,对应Usertb表，代表数据
//他的一个对象，对应Usertb表的一条记录
package com.zh.model;

public class UserBean {
	
	private String U_no;
	private String U_name;
	private String U_pwd;
	private String U_sex;
	private int U_age;
	private String U_tel;
	
	public String getU_no() {
		return U_no;
	}
	public void setU_no(String u_no) {
		U_no = u_no;
	}
	public String getU_name() {
		return U_name;
	}
	public void setU_name(String u_name) {
		U_name = u_name;
	}
	public String getU_pwd() {
		return U_pwd;
	}
	public void setU_pwd(String u_pwd) {
		U_pwd = u_pwd;
	}
	public String getU_sex() {
		return U_sex;
	}
	public void setU_sex(String u_sex) {
		U_sex = u_sex;
	}
	public int getU_age() {
		return U_age;
	}
	public void setU_age(int u_age) {
		this.U_age = u_age;
	}
	public String getU_tel() {
		return U_tel;
	}
	public void setU_tel(String u_tel) {
		this.U_tel = u_tel;
	}
	
	
}
