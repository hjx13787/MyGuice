package com.test.mina;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MainClient {
	private static MainClient mainClient = null;
	NioSocketConnector connector = new NioSocketConnector();
	DefaultIoFilterChainBuilder chain = connector.getFilterChain();

	public static MainClient getInstances() {
		if (null == mainClient) {
			mainClient = new MainClient();
		}
		return mainClient;
	}

	private MainClient() {
		chain.addLast("myChin", new ProtocolCodecFilter(
				new ObjectSerializationCodecFactory()));
//		chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(
//			Charset.forName("UTF-8"))) );
		connector.setHandler(ClientHandler.getInstances());
		connector.setConnectTimeout(30);
		connector.setConnectTimeoutMillis(30000);
		ConnectFuture cf = connector.connect(new InetSocketAddress("192.168.1.45",
				8887));
	}

	public static void main(String args[]) {
		MainClient.getInstances();
	}
}
