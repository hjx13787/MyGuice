package sys.my.pro.ui.manage;

import org.eclipse.jface.action.Action;

import sys.my.pro.ui.user.UserAction;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

public class InjectModule extends AbstractModule {

    
    protected void configure() {
	Multibinder<Action> moduleActions = Multibinder.newSetBinder(
              binder(), Action.class, Names.named("ModuleActions"));
	moduleActions.addBinding().to(UserAction.class);
	System.out.println("qqqqqqqqqqqqqqqqqqqq");
    }

}
