package sys.my.pro.ui;

import org.eclipse.core.databinding.observable.Realm;

import sys.my.pro.ui.guice.GuiceMudle;
import sys.my.pro.ui.manage.AddUIModule;
import sys.my.pro.ui.manage.Manage;
import sys.my.pro.ui.splash.SplashEvent;
import sys.my.pro.ui.splash.SplashPresenter;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainUIApp {

    public static void main(String[] args) {
	final Injector injector = Guice.createInjector();

	Display.getDefault().dispose();
	Display display = Display.getDefault();
	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
	    public void run() {
		
		Manage manage = injector.getInstance(Manage.class);
		MyMainView my = new MyMainView(manage);
		// MyMainView my=injector.getInstance(MyMainView.class);
		my.setBlockOnOpen(true);
		EventBus eb = new EventBus();
		eb.register(injector.getInstance(SplashPresenter.class));
		SplashEvent e = new SplashEvent("test");
		eb.post(e);
		my.open();
		
		
		Display.getCurrent().dispose();
	    }
	});
    }
}
