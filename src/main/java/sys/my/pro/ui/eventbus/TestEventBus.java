package sys.my.pro.ui.eventbus;

import com.google.common.eventbus.EventBus;

public class TestEventBus {
    public static void main(String[] args) {
	EventBus e=new EventBus("test");
	MessageListener l=new MessageListener();
	e.register(l);
	
	e.post(new MessageEvent("111"));
	e.post(new MessageEvent("222"));
	e.post(new MessageEvent("333"));
	System.out.println(l.getLastMsg());
	
    }
}
