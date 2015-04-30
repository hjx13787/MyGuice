package sys.my.pro.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.jface.action.Action;


/**
 * 界面模块，界面模块需要注册到UIModuleRegistry中才能够被使用。
 *
 * @author wudong
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UIModule {

	/**
	 * 界面模块的标识符。
	 *
	 * @return
	 */
	String moduleID();

	/**
	 * 用来进行显示的模块的名称。
	 *
	 * @return
	 */
	String moduleName();



	Class<?> moduleActionClass();

}
