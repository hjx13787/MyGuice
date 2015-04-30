package sys.my.pro.ui.manage;

import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import sys.my.pro.ui.UIModule;
import sys.my.pro.ui.action.ExitAction;
import sys.my.pro.ui.action.ManageAction;
import sys.my.pro.ui.user.UserAction;
import sys.my.pro.ui.user.UserManagePersenter;
/**
 * 创建界面工具
 * @author Michael
 *
 */
@Singleton
public class Manage{
    @Inject
    private ExitAction exitAction;
    @Inject
    private ManageAction manageAction;
    
    private List<Action> moduleActions;
    
    @Inject
    private AddUIModule addUIModule;
    
    public MenuManager getMenuManager() {
	MenuManager menuBar = new MenuManager("");
	MenuManager fileMenu = new MenuManager("程序");
	MenuManager helpMenu = new MenuManager("帮助");
	menuBar.add(fileMenu);
	menuBar.add(helpMenu);
	menuBar.add((IAction) this.exitAction);

	fileMenu.add((IAction) this.exitAction);
	helpMenu.add((IAction) this.exitAction);

	return menuBar;
    }
    /**
     * 创建工具栏
     * @return
     */
    public CoolBarManager getCoolBarManager() {
	CoolBarManager coolBarManager = new CoolBarManager(SWT.FLAT
                | SWT.HORIZONTAL);

        ToolBarManager tbMain = new ToolBarManager(SWT.FLAT);

        tbMain.add((IAction) this.manageAction);

        coolBarManager.add(tbMain);

        // the main module.
        ToolBarManager tbmodules = new ToolBarManager(SWT.FLAT);
        //获取注解中的数据
        UIModule ui=UserManagePersenter.class.getAnnotation(UIModule.class);
        Class<?> c=ui.moduleActionClass();
        UserAction u=new UserAction();
        tbmodules.add((IAction)c.cast(u));
        
        moduleActions=addUIModule.getActions();
        if(moduleActions!=null){
	    for (Action a : this.moduleActions) {
		tbmodules.add((IAction) a);
	    }
        }

        coolBarManager.add(tbmodules);

        ToolBarManager tbsystem = new ToolBarManager(SWT.FLAT);
//        //tbsystem.add((IAction) this.preferenceAction);
//        //tbsystem.add((IAction) this.helpAction);
//        tbsystem.add((IAction) this.passwordAction);
        tbsystem.add((IAction) this.manageAction);
        tbsystem.add((IAction) this.exitAction);
        coolBarManager.add(tbsystem);

        return coolBarManager;
    }

    public StatusLineManager getStatusLineManager() {
	StatusLineManager statusLineManager = new StatusLineManager();
        statusLineManager.add(exitAction);
        return statusLineManager;
    }
}
