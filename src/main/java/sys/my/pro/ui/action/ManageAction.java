package sys.my.pro.ui.action;

import org.eclipse.jface.action.Action;

import sys.my.pro.ui.MyMainPresenter;
import sys.my.pro.ui.MyMainView;

public class ManageAction extends Action {
    MyMainView myMainView=new MyMainView();
    MyMainPresenter presenter=new MyMainPresenter(myMainView);
    public ManageAction() {
	// TODO Auto-generated constructor stub
	setText("系统管理");
	setToolTipText("对系统的一些操作");
    }
    
    @Override
    public void run() {
        System.out.println("进入系统管理");
        presenter.show();
    }
}
