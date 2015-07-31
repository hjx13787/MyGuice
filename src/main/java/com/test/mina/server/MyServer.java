package com.test.mina.server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;



public class MyServer {  
    //main方法：  
    public static void main(String[] args) throws Exception {
	IoAcceptor acceptor=new NioSocketAcceptor(3);  
	acceptor.getSessionConfig().setReadBufferSize(2048);  
	acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
	
	 //acceptor.getFilterChain().addLast("logger", new LoggingFilter()); 
	acceptor.getFilterChain().addLast("codec", (IoFilter) new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));
	acceptor.getFilterChain().addLast("threadPool", (IoFilter) new ExecutorFilter(Executors.newCachedThreadPool())); 
	
	acceptor.setHandler(new MyIoHandler());
	acceptor.bind(new InetSocketAddress(9123));
	
    }
  
}