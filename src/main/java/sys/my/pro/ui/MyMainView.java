package sys.my.pro.ui;

import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import sys.my.pro.ui.manage.Manage;
import sys.my.pro.ui.splash.SplashView;

import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;

import com.test.composite.TestComposite;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;


@SuppressWarnings("unused")
public class MyMainView extends ApplicationWindow {
    private static final String TAB_MODULE_ID = "__TAB_MODULE_ID__";
    public static final String MIG_LAYOUT_MAIN = "fill, insets 1";
    public static final String LOGIN_CONTAINER_LAYOUT_DATA = "width 300px!, height 150px!";
    public static final String MAIN_FOLDER_LAYOUT_DATA = "grow, hmin 0, wmin 0";
    
    private Manage manage;
    private Composite mainContainer;
    
    
    public MyMainView(Manage manage) {
	super(null);
	
	this.manage=manage;
	addCoolBar(SWT.NONE);
	addMenuBar();
	addStatusLine();
    }
    /**
     * 添加菜单栏
     */
    @Override
    protected MenuManager createMenuManager() {
        return manage.getMenuManager();
    }
    /**
     * 添加工具栏
     */
    @Override
    protected CoolBarManager createCoolBarManager(int style) {
        return manage.getCoolBarManager();
    }
    /**
     * 添加状态栏
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        return manage.getStatusLineManager();
    }
    
    @Override
    protected Control createContents(Composite parent) {
	mainContainer = new Composite(parent, SWT.NONE);
	RowLayout rl_mainContainer = new RowLayout(SWT.HORIZONTAL);
	rl_mainContainer.justify = true;
	mainContainer.setLayout(rl_mainContainer);
	
	Composite composite = new SplashView(mainContainer, SWT.NONE);
	
	
	return mainContainer;
    }
    
    public void layoutMainContainer() {
        this.mainContainer.layout(true);
    }
    
    
    public Composite getMainContainer() {
	return mainContainer;
    }
}
