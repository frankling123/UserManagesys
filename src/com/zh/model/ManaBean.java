//这是一个javabean,对应Manatb表，代表数据
//他的一个对象，对应Manatb表的一条记录
package com.zh.model;

public class ManaBean {

	private String M_no;
	private String M_pwd;
	private int grade;
	public String getM_no() {
		return M_no;
	}
	public void setM_no(String m_no) {
		M_no = m_no;
	}
	public String getM_pwd() {
		return M_pwd;
	}
	public void setM_pwd(String m_pwd) {
		M_pwd = m_pwd;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
