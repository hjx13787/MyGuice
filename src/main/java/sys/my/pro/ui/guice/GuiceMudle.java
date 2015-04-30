package sys.my.pro.ui.guice;

import com.google.inject.AbstractModule;

public class GuiceMudle extends AbstractModule {

    @Override
    protected void configure() {
	
	binder().bind(GuiceI.class).to(GuiceImpl.class);

    }
    

}
