package sys.my.pro.ui.splash;

import sys.my.pro.ui.i.Presenter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class SplashPresenter implements Presenter {
    @Inject
    private SplashView splashView;
    @Subscribe
    public void listen(SplashEvent event){
	System.out.println(event.getMsg());
	SplashModel m=new SplashModel();
	m.setMessage(event.getMsg());
	splashView.setModel(m);
    }
    
    public SplashView getSplashView() {
	return splashView;
    }
    
}
