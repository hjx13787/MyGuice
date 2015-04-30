package sys.my.pro.ui.manage;


import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.action.Action;

import sys.my.pro.ui.UIModule;
import sys.my.pro.ui.i.Presenter;
import sys.my.pro.ui.user.UserManagePersenter;

/**
 * 添加模块
 * 
 */
public class AddUIModule extends AbstractModule {

    // 在此处对模块顺序进行调整
    public static Class<?>[] all_modules = {UserManagePersenter.class};


    @Override
    protected void configure() {
	Multibinder<Presenter> modules = Multibinder.newSetBinder(binder(),
                Presenter.class, Names.named("UIModules"));
//	
//        Multibinder<Action> moduleActions = Multibinder.newSetBinder(
//                binder(), Action.class, Names.named("ModuleActions"));

       List<Action>  list= new ArrayList<Action>();
       
        /*
         * 根据注解获取信息
         */

        Iterable<Class<?>> annotated = Arrays.asList(all_modules);

        for (Class<?> class1 : annotated) {
            if (Presenter.class.isAssignableFrom(class1)) {

                Class<Presenter> p = (Class<Presenter>) class1;
                UIModule annotation = p.getAnnotation(UIModule.class);
                if (annotation == null) {
                    continue;
                }



                modules.addBinding().to(p);

                Class<? extends Action> moduleActionClass = (Class<? extends Action>) annotation
                        .moduleActionClass();
                
                
                if (moduleActionClass != null) {
//                    moduleActions.addBinding().to(moduleActionClass);
//                    moduleActions.add(Action.class.cast(obj)moduleActionClass);
                    Action a=Action.class.cast(moduleActionClass);
                    list.add(a);
                }
            }
        }
        ;
        
        this.bind(Actions.class).annotatedWith(Names.named("ModuleActions")).toInstance(new Actions(list));
//        this.bind(ContributionManager.class).to(ContributionManagerImpl.class);
//        this.install(new AppActionConfiguratorModule());
    }

    
}
