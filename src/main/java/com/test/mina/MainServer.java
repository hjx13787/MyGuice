package com.test.mina;
import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MainServer {
	private static MainServer mainServer = null;
	private SocketAcceptor acceptor = new NioSocketAcceptor();
	private DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
	private int bindPort = 8887;

	public static MainServer getInstances() {
		if (null == mainServer) {
			mainServer = new MainServer();
		}
		return mainServer;
	}

	private MainServer() {
		//创建I/O Filter Chain
		//ProtocolCodecFilter实例用来编码数据，这里使用了ObjectSerializationCodecFactory类来序列化或反序列化数据成java对象。
		chain.addLast("myChin", new ProtocolCodecFilter(
				new ObjectSerializationCodecFactory()));
//		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(
//			Charset.forName("UTF-8"))) );
		acceptor.setHandler(ServerHandler.getInstances());
		try {
			//让IoAcceptor类实例绑定端口实现监听
			acceptor.bind(new InetSocketAddress(bindPort));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		MainServer.getInstances();
	}
}
