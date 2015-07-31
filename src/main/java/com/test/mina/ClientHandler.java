package com.test.mina;
import java.util.ArrayList;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler extends IoHandlerAdapter {
	private static ClientHandler samplMinaClientHandler = null;
	public static ClientHandler getInstances() {
		if (null == samplMinaClientHandler) {
			samplMinaClientHandler = new ClientHandler();
		}
		return samplMinaClientHandler;
	}

	private ClientHandler() {

	}

	public void sessionOpened(IoSession session) throws Exception {
		session.write("客户端与服务器的会话打开了……");
		UserInfo text=new UserInfo();
		text.setName("梅竹寒香");
		text.setQQNum("972341215");
		
		Student s1 = new Student();
		s1.setAge(89);
		s1.setSname("bianzhe");
		
		Student s2 = new Student();
		s2.setAge(88);
		s2.setSname("ganxin");
		
		Condition con = new Condition();
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		con.setStudents(students);
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		users.add(text);
		con.setUsers(users);
		
		//session.write(con);
		session.write(con);
		session.write(text);
	}

	public void sessionClosed(IoSession session) {
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
	    if(message instanceof UserInfo){
		UserInfo i=(UserInfo) message;
		System.out.println("客户端从服务端接收到的name="+i.getName());
		System.out.println("客户端从服务端接收到的QQnum="+i.getQQNum());
	    }else{
		System.out.println("xxxxx");
	    }
	    
	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		System.out.println("客户端已经向服务器发送了："+arg1.toString());
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
		throws Exception {
	    
	    super.exceptionCaught(session, cause);
	}
	
	
}
