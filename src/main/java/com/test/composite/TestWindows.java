package com.test.composite;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;


public class TestWindows extends ApplicationWindow {
    private Composite com;
    public TestWindows(Shell parentShell) {
	super(parentShell);
	
    }
    
    @Override
    protected Control createContents(Composite parent) {
	com=new Composite(parent, SWT.NONE);
	com.setLayout(new GridLayout(1, false));
	
	Composite composite = new Composite(com, SWT.NONE);
	
	Button btnNewButton = new Button(composite, SWT.NONE);
	btnNewButton.setBounds(0, 10, 80, 27);
	btnNewButton.setText("New Button");
	
	TestComposite composite_1 = new TestComposite(com, SWT.NONE);
	GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
	gd_composite_1.widthHint = 83;
	composite_1.setLayoutData(gd_composite_1);
        return com;
    }
    public static void main(String[] args) {
	TestWindows t=new TestWindows(null);
	t.setBlockOnOpen(true);
	t.open();
	Display.getDefault().dispose();
    }
}
