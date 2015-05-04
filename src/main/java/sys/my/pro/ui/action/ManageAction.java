package sys.my.pro.ui.action;

import org.eclipse.jface.action.Action;

import com.google.inject.Inject;

import sys.my.pro.ui.MyMainPresenter;
import sys.my.pro.ui.MyMainView;

public class ManageAction extends Action {
    public ManageAction() {
	// TODO Auto-generated constructor stub
	setText("系统管理");
	setToolTipText("对系统的一些操作");
    }
    
    @Override
    public void run() {
        System.out.println("进入系统管理");
    }
}
