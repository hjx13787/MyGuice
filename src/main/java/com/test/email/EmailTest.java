package com.test.email;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailTest {
	public static void main(String[] args) {
		SimpleEmail email = new SimpleEmail();
		try {
			   email.setHostName("smtp.qq.com"); //Yahoo的服务器地址是：smtp.mail.yahoo.com
			   email.addTo("hjx13787@163.com", "John Doe"); 
			   email.setFrom("2954775548@qq.com", "Mr Smith");
			   email.setAuthentication("2954775548@qq.com", "");
			   email.setSubject("Test message");
			   email.setMsg("This is a simple test of commons-email");
			   email.send();
			  } catch (EmailException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
	}
}
