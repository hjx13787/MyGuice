package com.test.util;

public class UserDir {
	public static void main(String[] args) {
		String s=System.getProperty("user.dir");
		System.out.println(s);
		int no=s.lastIndexOf("\\");
		System.out.println(s.substring(0, no));
		String s1=s.substring(0, no);
		s1.lastIndexOf("\\");
		System.out.println(s.substring(0, s.lastIndexOf("\\")).substring(0, s.substring(0, s.lastIndexOf("\\")).lastIndexOf("\\")));
	}
}
