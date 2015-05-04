package sys.my.pro.ui.eventbus;

public class MessageEvent {
    private String msg;
    
    public MessageEvent(String msg){
	this.msg=msg;
    }
    
    public String getMsg() {
	return msg;
    }
}
