package com.test.mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler implements IoHandler {
    
    /**
     * 当用户代码抛出异常或是mina抛出运行时异常时会调用此方法，注意如果这个异常是IO异常的话connection就会关闭。
     */
    public void exceptionCaught(IoSession session, Throwable cause)
	    throws Exception {
	cause.printStackTrace();
    }
    /**
     * 当接收到消息时就会调用此方法，这个方法是我们最经常用到的方法，这个方法中要尽量定义所有的可能的对接收消息的操作。
     */
    public void messageReceived(IoSession session, Object message)
	    throws Exception {
	String str = message.toString();
	if (str.trim().equalsIgnoreCase("quit")) {
	    session.close();
	    return;
	}

	Date date = new Date();
	session.write(date.toString());
	session.setAttribute("test", str);
	System.out.println("Message written...");
    }
    /**
     * 当某个session变为idle时会调用此方法，但是在udp通信中是无效的
     */
    public void sessionIdle(IoSession session, IdleStatus status)
	    throws Exception {
	System.out.println("IDLE " + session.getIdleCount(status));
    }
    /**
     * 当消息发送完成时候会被调用，也就是调用 IoSession.write()方法后
     */
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
	System.out.println("messageSent=="+arg1+"=="+arg0.getAttribute("test"));
    }
    
    /**
     * 当session关闭的时候会调用此方法，我们可以在这里定义一些session关闭后的资源清理操作来释放session相关的资源。
     */
    public void sessionClosed(IoSession arg0) throws Exception {
	System.out.println("sessionClosed");
    }
    /**
     * 当一个新的connection创建的时候，这个事件就会被触发，对于TCP请求来说是三次握手的最后一次请求成功，
     * 对于UDP协议来说是收到数据报报文的时候，我们可以在这个方法中加入对session初始化的一些操作和配置
     */
    public void sessionCreated(IoSession arg0) throws Exception {
	System.out.println("sessionCreated");
    }
    /**
     * 当connection打开的时候会被触发，一般来说就是sessionCreated之后，
    	如果在这里面定义或者是配置指定的线程，那么将不会调用 I/O processor thread来完成以后的工作
     */
    public void sessionOpened(IoSession arg0) throws Exception {
	System.out.println("sessionOpened");
    }
}
