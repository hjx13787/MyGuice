package com.test.date;

import java.net.URL;
import java.util.Date;

public class BjDate {
    public static void main(String[] args) throws Exception {
	 java.util.Locale locale=java.util.Locale.CHINESE; //这是获得本地中国时区  
	 String pattern = "yyyy-MM-dd kk:mm:ss zZ";//这是日期格式  
	 java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern,locale);//设定日期格式  
	 java.util.Date date = new java.util.Date();  
	 java.net.URL url=new URL("http://www.bjtime.cn");//取得资源对象  
	 java.net.URLConnection uc=url.openConnection();//生成连接对象   
	 uc.connect(); //发出连接   
	 long ld=uc.getDate(); //取得网站日期时间   
	 date=new Date(ld); //转换为标准时间对象  
	 String bjTime = df.format(date);  
	 System.out.println("北京时间:"+bjTime);
    }
}
