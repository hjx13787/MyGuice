package sys.my.pro.ui.eventbus;

import com.google.common.eventbus.Subscribe;

public class MessageListener {
    private String lastMsg;
    
    @Subscribe
    public void listen(MessageEvent event){
	lastMsg=event.getMsg();
	System.out.println(lastMsg);
    }
    
    public String getLastMsg() {
	return lastMsg;
    }
}
