package sys.my.pro.ui.user;

import org.eclipse.jface.action.Action;

public class UserAction extends Action {
    public UserAction() {
	this.setText("用户管理");
	setToolTipText("用户管理");
	
    }
    @Override
    public void run() {
       System.out.println("进入用户管理");
    }
}
