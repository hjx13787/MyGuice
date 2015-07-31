package com.test.mina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.test.mina.User;

public class MyClient {
    public static void main(String[] args) {
	User u=new User();
	u.setName("hjx");
	u.setPwd("pwd");
	for(int i=0;i<1;i++){
	IoConnector connector = new NioSocketConnector();
	connector.setConnectTimeoutMillis(30000);
	connector.getFilterChain().addLast(
		"codec",
		(IoFilter) new ProtocolCodecFilter(new TextLineCodecFactory(
			Charset.forName("UTF-8"))));
	
	    connector.setHandler(new ClientHandler(i+"开始连接"));
		ConnectFuture connFuture = connector.connect(new InetSocketAddress(
			"localhost", 9123));
		connFuture.addListener(new ConnectListener(i));
		//System.out.println(i+"开始请求");
	}
    }
}

/**
 * 请求的监听器
 * @author Michael
 *
 */
class ConnectListener implements IoFutureListener<ConnectFuture >{
    int i;
    public ConnectListener(int i){
	this.i=i;
    }
	public void operationComplete(ConnectFuture future) {
		
		if (future.isConnected()) {
		    
		} else {
		    System.out.println("error");
		}
	}
}
