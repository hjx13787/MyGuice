package com.test.composite;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

import sys.my.pro.ui.manage.BasicJavaBeanModel;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.swt.widgets.Text;


public class TestComposite extends Composite {
	private DataBindingContext m_bindingContext;
    
    
    
    TestModel model=new TestModel();
    private Label lblTest;
    private Text text;
    public TestComposite(Composite parent, int style) {
	super(parent, style);
	model.name=1;
	lblTest = new Label(this, SWT.NONE);
	lblTest.setBounds(182, 152, 61, 17);
	
	text = new Text(this, SWT.BORDER);
	text.setBounds(158, 105, 73, 23);
	m_bindingContext = initDataBindings();
    }
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}
}
