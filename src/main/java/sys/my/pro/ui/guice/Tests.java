package sys.my.pro.ui.guice;

import java.util.Set;

import org.eclipse.jface.action.Action;

import sys.my.pro.ui.manage.InjectModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;


public class Tests {
    @Inject
    @Named("ModuleActions")
    private Set<Action> test;
    
    
    public Tests() {
	System.out.println(test);
    }
    public static void main(String[] args) {
	Injector injector=Guice.createInjector(new InjectModule());
//	InjectModule injectModule=injector.getInstance(InjectModule.class);
//	injector=injector.createChildInjector(injectModule);
	injector.getInstance(Tests.class);
    }
    
}
