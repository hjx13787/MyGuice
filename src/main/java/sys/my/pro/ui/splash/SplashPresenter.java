package sys.my.pro.ui.splash;

import sys.my.pro.ui.i.Presenter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class SplashPresenter implements Presenter {
//    @Inject
    private SplashView view;
//    @Inject
    private EventBus ebus;
    
//    @Inject
    private SplashEvent event;
    
//    @Subscribe
    public void init(){
	view.getModel().setMessage(event.getMsg());
    }
    
    public SplashView getView() {
	return view;
    }
}
