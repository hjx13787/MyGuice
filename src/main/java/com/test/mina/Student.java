package com.test.mina;
public class Student implements java.io.Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = -2152056263641302436L;
	private String sname;
	private Integer age;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
