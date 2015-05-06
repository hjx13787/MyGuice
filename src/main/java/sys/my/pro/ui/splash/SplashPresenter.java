package sys.my.pro.ui.splash;

import sys.my.pro.ui.i.Presenter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class SplashPresenter implements Presenter {
    
    @Subscribe
    public void listen(SplashEvent event){
	System.out.println(event.getMsg());
    }
    
}
