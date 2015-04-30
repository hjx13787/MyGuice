package sys.my.pro.ui.action;

import org.eclipse.jface.action.Action;

public class ExitAction extends Action {
    
    public ExitAction() {
	this.setText("退出");
	this.setToolTipText("退出一卡通管理平台");
	
    }
    
    @Override
    public void run() {
        System.out.println("用户退出");
        System.exit(0);
    }
    
    
}
