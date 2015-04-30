package com.test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyTestAnnotation(name="admin",pwd="12345")
public class MyTestSample {
    @MyFieldAnnotation(uri="qqqqqq",desc="ddddd")
    public String id;
    
    @MyMethodAnnotation(uri="11111",desc="qqqqq")
    public void setId(String id)
    {
        this.id = id;
    }
    
    public static void main(String[] args) throws Exception{
	MyTestAnnotation m=MyTestSample.class.getAnnotation(MyTestAnnotation.class);
	System.out.println(m.name()+"=========="+m.pwd());
	Method me=MyTestSample.class.getDeclaredMethod("setId", String.class);
	MyMethodAnnotation mm=me.getAnnotation(MyMethodAnnotation.class);
	System.out.println(mm.uri()+"mmmmmmmmmmm"+mm.desc());
	
	Field f=MyTestSample.class.getDeclaredField("id");
	MyFieldAnnotation myf=f.getAnnotation(MyFieldAnnotation.class);
	System.out.println(myf.uri()+"fffffffffff"+myf.desc());
	
    }
}
