package sys.my.pro.ui;

import com.google.inject.Inject;

import sys.my.pro.ui.i.Presenter;
import sys.my.pro.ui.splash.SplashPresenter;

public class MyMainPresenter implements Presenter{
    @Inject
    private MyMainView view;
    @Inject
    private SplashPresenter sp;

    public void close() {
	this.view.close();
    }
    public void show(){
	this.view.open();
    }

}
