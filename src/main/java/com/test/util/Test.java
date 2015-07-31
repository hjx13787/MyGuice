package com.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String t="户${customerName}你好！本次消费金额${amount}，"
                + "您帐户${accountNumber}上的余额为${balance}，欢迎下次光临！";
		String rex="\\$\\{([a-zA-Z]+)\\}";
		Pattern p=Pattern.compile(rex);
		System.out.println(p);
		Matcher m=p.matcher(t);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, "\\$ss");
		}
		System.out.println(sb);
	}
}
