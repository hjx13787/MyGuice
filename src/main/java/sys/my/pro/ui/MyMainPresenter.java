package sys.my.pro.ui;

import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

import sys.my.pro.ui.i.Presenter;
import sys.my.pro.ui.splash.SplashPresenter;

public class MyMainPresenter implements Presenter{
    @Inject
    private MyMainView view;
    @Inject
    private SplashPresenter sp;
    
    public void showSplashWindow() {
       sp.getSplashView();
        view.layoutMainContainer();
//        view.createLoginContainer();
    }

    public void close() {
	this.view.close();
    }
    public void show(){
	showSplashWindow();
	this.view.open();
	
    }
    public SplashPresenter getSp() {
	return sp;
    }

}
