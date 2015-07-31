package com.test.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class TimeMachineServer {

	    private static final int PORT = 9123;

	    public static void main( String[] args ) throws IOException
	    {
	        IoAcceptor acceptor = new NioSocketAcceptor();
	        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();  
	        
	        LoggingFilter loggingFilter = new LoggingFilter();  
//	        loggingFilter.setSessionClosedLogLevel(LogLevel.NONE);  
//	        loggingFilter.setSessionCreatedLogLevel(LogLevel.DEBUG);  
//	        loggingFilter.setSessionOpenedLogLevel(LogLevel.INFO); 
//	        chain.addLast( "logger", loggingFilter );
	        chain.addLast( "codec", new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ))));

	        acceptor.setHandler( new TimeServerHandler() );
		acceptor.getSessionConfig().setReadBufferSize( 2048 );
	        acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE, 10 );
	        acceptor.bind( new InetSocketAddress(PORT) );
	    }

}