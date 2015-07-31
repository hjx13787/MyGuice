package com.test.mina.server;

import java.util.Date;

import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyIoHandler extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message)
	    throws Exception {
	Thread.sleep(2000);
	String str = message.toString();
	System.out.println(session+"===message==="+message);
	WriteFuture wf=session.write(new Date().toString()+"=="+message);
	wf.addListener(new WriteLisenter());
	if (str.endsWith("quit")) {
	    session.close(true);
	    return;
	}
    }
    
    class WriteLisenter implements IoFutureListener<WriteFuture>{

	public void operationComplete(WriteFuture future) {
	    if(future.isWritten()){
		IoSession session=future.getSession();
//		    session.setAttribute("ttt", "tttt"+session);
//		    System.out.println("tttt==="+session);
	    }
	    
	}
	
    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        
    }
}
