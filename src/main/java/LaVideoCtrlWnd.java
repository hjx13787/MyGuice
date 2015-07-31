import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.internal.ole.win32.TYPEATTR;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleAutomation;
import org.eclipse.swt.ole.win32.OleControlSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.ole.win32.OleFunctionDescription;
import org.eclipse.swt.ole.win32.OlePropertyDescription;
import org.eclipse.swt.ole.win32.Variant;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import LaVideo.LaVideoCtrl;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;


public class LaVideoCtrlWnd {
	
	private static LaVideoCtrl ocx;
	private static Shell sShell = null;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LaVideoCtrlWnd window = new LaVideoCtrlWnd();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		createActivex();
		sShell.open();
		sShell.layout();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		GridData gridData = new GridData();
		  gridData.horizontalSpan = 2;
		  GridLayout gridLayout = new GridLayout();
		  gridLayout.numColumns = 2;
		  sShell = new Shell();
		  sShell.setSize(660, 500);
		  sShell.setText("Video SWT DEMO");
		  sShell.setLayout(gridLayout);
		  
		  Menu menu = new Menu(sShell, SWT.BAR);
		  sShell.setMenuBar(menu);
		  
		  MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		  mntmNewSubmenu.setText("\u64CD\u4F5C");
		  
		  Menu menu_1 = new Menu(mntmNewSubmenu);
		  mntmNewSubmenu.setMenu(menu_1);
		  
		  MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem.addSelectionListener(new SelectionAdapter() {
		  	public void widgetDefaultSelected(SelectionEvent e) {
		  		ocx.StartPreview();
		  	}
		  });
		  mntmNewItem.setText("\u5F00\u59CB\u9884\u89C8");
		  
		  MenuItem mntmNewItem_1 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
		  	public void widgetDefaultSelected(SelectionEvent e) {
		  		ocx.StopPreview();
		  	}
		  });
		  mntmNewItem_1.setText("\u505C\u6B62\u9884\u89C8");
		  
		  MenuItem mntmNewItem_2 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.Scan("C:\\12345.jpg");
		  	}
		  });
		  
		  
		  mntmNewItem_2.setText("\u62CD\u7167\r\n");
		  
		  MenuItem menuItem = new MenuItem(menu_1, SWT.NONE);
		  menuItem.setText("\u7EA0\u504F");
		  
		  MenuItem mntmNewItem_3 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_3.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.RotateLeft();
		  	}
		  });
		  mntmNewItem_3.setText("\u5DE6\u65CB");
		  
		  MenuItem mntmNewItem_4 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_4.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.RotateRight();
		  	}
		  });
		  mntmNewItem_4.setText("\u53F3\u65CB");
		  
		  MenuItem mntmNewItem_5 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_5.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.VideoFit();
		  	}
		  });
		  mntmNewItem_5.setText("\u9002\u5408\u6A21\u5F0F");
		  
		  MenuItem mntmNewItem_6 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_6.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.VideoFill();
		  	}
		  });
		  mntmNewItem_6.setText("\u5168\u5C4F\u6A21\u5F0F");
		  
		  MenuItem mntmNewItem_7 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_7.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.ZoomIn();
		  	}
		  });
		  mntmNewItem_7.setText("\u653E\u5927");
		  
		  MenuItem mntmNewItem_8 = new MenuItem(menu_1, SWT.NONE);
		  mntmNewItem_8.addSelectionListener(new SelectionAdapter() {
		  	public void widgetSelected(SelectionEvent e) {
		  		ocx.ZoomOut();
		  	}
		  });
		  mntmNewItem_8.setText("\u7F29\u5C0F");
		  
		  
		  
		 
	}
	
	private void createActivex()
	{
		ocx=new LaVideoCtrl();
		ocx.InitOcx(sShell);		
		ocx.SetFrameSize(660,500);	
		ocx.SetClientSize(640,480);	
		ocx.BuildVideo();
		ocx.StartPreview();
		//System.out.print("1122");
	}
}
