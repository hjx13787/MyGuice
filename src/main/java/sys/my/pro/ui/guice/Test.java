package sys.my.pro.ui.guice;

import java.util.Set;

import org.eclipse.jface.action.Action;

import sys.my.pro.ui.manage.AddUIModule;
import sys.my.pro.ui.manage.Manage;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {
    public static void main(String[] args) {
	Injector in=Guice.createInjector();
	GuiceI g=in.getInstance(GuiceI.class);
	g.sayHello();
	in.getInstance(Tests.class);
	in.getInstance(AddUIModule.class);
	System.out.println(in.getBindings());
	Set<Action> s=null;
	
	Manage mm=in.getInstance(Manage.class);
    }
}
