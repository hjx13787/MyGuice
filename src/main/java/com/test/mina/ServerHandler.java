package com.test.mina;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoFilterAdapter implements IoHandler {
	private static ServerHandler samplMinaServerHandler = null;

	public static ServerHandler getInstances() {
		if (null == samplMinaServerHandler) {
			samplMinaServerHandler = new ServerHandler();
		}
		return samplMinaServerHandler;
	}

	private ServerHandler() {

	}

	// 当连接后打开时触发此方法，一般此方法与 sessionCreated 会被同时触发
	public void sessionOpened(IoSession session) throws Exception {
	    
	}
	public void sessionClosed(IoSession session) {
	}
	/**
	 * 创建I/O Handler，这里主要看一下messageReceived方法，其接收了Object对象，然后又发送了一个Object对象给Client端。
	 */
	public void messageReceived(IoSession session, Object message)
			throws Exception {
	    System.out.println(message.toString());
		if (message instanceof UserInfo) {
			UserInfo text = (UserInfo) message;
			System.out.println("服务器接收到从客户端的姓名："+text.getName());
			System.out.println("服务器接收到从客户端的QQ："+text.getQQNum());
			text.setName("qqq");
			text.setQQNum("jjj");
			session.write(text);
		} 
		
		if (message instanceof Condition) {
			Condition text = (Condition) message;
			List<Student> students = text.getStudents();
			List<UserInfo> users = text.getUsers();
			System.out.println("服务器端接收到从客户端的学生信息数："+students.size());
			System.out.println("服务器端接收到从客户端的用户信息数："+users.size());
		} else{
			if(message instanceof Student){
				System.out.println("哈哈");
			}
			System.out.println("aaa"+message.getClass());
			
		}
	}

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {

	}

	// 当消息传送到客户端后触发
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		
	}

	// 当一个新客户端连接后触发此方法.
	public void sessionCreated(IoSession arg0) throws Exception {
		
	}

	// 当连接空闲时触发此方法.
	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		
	}

}
