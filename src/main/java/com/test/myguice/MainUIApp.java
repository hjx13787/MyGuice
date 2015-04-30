package com.test.myguice;



import org.eclipse.core.databinding.observable.Realm;

import sys.my.pro.ui.MyMainView;
import sys.my.pro.ui.guice.GuiceMudle;
import sys.my.pro.ui.manage.AddUIModule;
import sys.my.pro.ui.manage.Manage;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainUIApp {
    
    public static void main(String[] args) {
	final Injector injector=Guice.createInjector();
	final Display display = Display.getDefault();
	// run it from a realm
	Realm.runWithDefault(SWTObservables.getRealm(display),
                new Runnable() {
				public void run() {
					Shell shell = new Shell(Display.getDefault(),SWT.CLOSE | SWT.MIN);
					shell.setLayout(null);
					Manage m=injector.getInstance(Manage.class);
					MyMainView my=new MyMainView(m);
					my.open();
					
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
					display.dispose();
				}
			});
    }
}
