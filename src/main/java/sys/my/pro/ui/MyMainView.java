package sys.my.pro.ui;

import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;






import org.eclipse.swt.widgets.Widget;

import sys.my.pro.ui.manage.Manage;

import org.eclipse.wb.swt.SWTResourceManager;

public class MyMainView extends ApplicationWindow {
    private static final String TAB_MODULE_ID = "__TAB_MODULE_ID__";
    public static final String MIG_LAYOUT_MAIN = "fill, insets 1";
    public static final String LOGIN_CONTAINER_LAYOUT_DATA = "width 300px!, height 150px!";
    public static final String MAIN_FOLDER_LAYOUT_DATA = "grow, hmin 0, wmin 0";
    private Manage manage;

    public MyMainView(Manage manage) {
	super(null);
	this.manage=manage;
	addCoolBar(SWT.NONE);
	addMenuBar();
	addStatusLine();
    }
    public MyMainView(){
	super(null);
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
        // TODO Auto-generated method stub
        return manage.getCoolBarManager();
    }
    /**
     * 添加状态栏
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        // TODO Auto-generated method stub
        return manage.getStatusLineManager();
    }
    @Override
    protected void configureShell(final Shell shell) {
    	shell.setImage(SWTResourceManager.getImage(MyMainView.class, "/sun/print/resources/duplex.png"));
	shell.setMinimumSize(new Point(1024, 768));
        super.configureShell(shell);
        shell.setData("MAIN_SHELL_DONGLU");
        shell.setText("东陆一卡通管理平台");


    }
    
    

}
