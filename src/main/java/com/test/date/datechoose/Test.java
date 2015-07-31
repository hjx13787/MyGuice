package com.test.date.datechoose;

import com.ibm.icu.util.Calendar;

public class Test {
	public static void main(String[] args) {
		for(int i=0;i<365;i++){
			Calendar c=Calendar.getInstance();
			c.set(2015, 0, 1);
			c.add(Calendar.DATE, i);
			System.out.println(c.get(Calendar.DAY_OF_YEAR));
		}
	}
}
