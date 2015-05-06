package sys.my.pro.ui.splash;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;

import com.google.inject.Inject;
import org.eclipse.swt.widgets.Text;

public class SplashView extends Composite {
    private DataBindingContext m_bindingContext;
    
    @Inject
    private SplashModel model;
    
    private Label lblNewLabel;

    public SplashView(Composite parent, int style) {
	super(parent, style);
	
	lblNewLabel = new Label(this, SWT.NONE);
	lblNewLabel.setBounds(162, 161, 61, 17);
	m_bindingContext = initDataBindings();
    }
    public SplashModel getModel() {
	return model;
    }
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextLblNewLabelObserveWidget = WidgetProperties.text().observe(lblNewLabel);
		IObservableValue messageModelObserveValue = BeanProperties.value("message").observe(model);
		bindingContext.bindValue(observeTextLblNewLabelObserveWidget, messageModelObserveValue, null, null);
		//
		return bindingContext;
	}
}
