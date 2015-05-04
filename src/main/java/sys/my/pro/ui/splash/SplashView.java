package sys.my.pro.ui.splash;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;

import com.google.inject.Inject;

public class SplashView extends Composite {
    private DataBindingContext m_bindingContext;
//    @Inject
    private SplashModel model;
    private Label label;

    public SplashView(Composite parent, int style) {
	super(parent, style);
	
	label = new Label(this, SWT.NONE);
	label.setBounds(183, 134, 61, 17);
	label.setText("初始化");
	m_bindingContext = initDataBindings();
    }
    
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextLabelObserveWidget = WidgetProperties.text().observe(label);
		IObservableValue messageModelObserveValue = BeanProperties.value("message").observe(model);
		bindingContext.bindValue(observeTextLabelObserveWidget, messageModelObserveValue, null, null);
		//
		return bindingContext;
	}
	
	public SplashModel getModel() {
	    return model;
	}
}
