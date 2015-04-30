package com.test.myguice;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;

public class Login extends Dialog{
	private DataBindingContext m_bindingContext;

    private Text text;
    private Text text_1;

    private Button button;
    private Label lblNewLabel;
    private Text text_2;
    private LoginModol lm;
    protected Login(Shell parentShell) {
	super(parentShell);
	
    }
    @Override
    protected Control createDialogArea(Composite parent) {
	lm=new LoginModol();
	lm.setUsername("1111");
	lm.setMsg("请输入用户名密码");
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new FillLayout());

        final Composite composite = new Composite(container, SWT.NONE);

        button = new Button(composite, SWT.NONE);
        button.setBounds(65, 182, 82, 33);
        button.setText("登录");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                login();
            }

	   
        });

        Button button_1 = new Button(composite, SWT.NONE);
        button_1.setText("退出");
        button_1.setBounds(170, 182, 82, 33);
        button_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                cancelPressed();
            }
        });

        Composite composite_1 = new Composite(composite, SWT.NONE);
        composite_1.setBounds(0, 0, 315, 69);

        lblNewLabel = new Label(composite_1, SWT.SHADOW_NONE);
        lblNewLabel.setBounds(10, 5, 61, 59);

        Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
        lblNewLabel_2.setAlignment(SWT.CENTER);
        lblNewLabel_2.setBounds(61, 23, 231, 36);
        lblNewLabel_2.setText("登录");

        Composite composite_2 = new Composite(composite, SWT.NONE);
        composite_2.setBounds(21, 89, 272, 33);

        text = new Text(composite_2, SWT.BORDER);
        text.setBounds(97, 4, 150, 25);
        text.setFocus();

        Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
        lblNewLabel_1.setBounds(10, 6, 58, 20);
        lblNewLabel_1.setAlignment(SWT.RIGHT);
        lblNewLabel_1.setText("用户名");

        Composite composite_3 = new Composite(composite, SWT.NONE);
        composite_3.setBounds(21, 122, 272, 33);

        text_1 = new Text(composite_3, SWT.BORDER | SWT.PASSWORD);
        text_1.setBounds(97, 4, 150, 25);
        text_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR) {
                    login();
                }
            }
        });

        Label label = new Label(composite_3, SWT.NONE);
        label.setBounds(10, 6, 58, 20);
        label.setText("密　码");
        label.setAlignment(SWT.RIGHT);

        text_2 = new Text(composite, SWT.NONE);
        text_2.setEnabled(false);
        text_2.setEditable(false);
        text_2.setBackground(composite.getBackground());
        text_2.setBounds(46, 158, 222, 18);
        text_2.setText("1");
        m_bindingContext = initDataBindings();

        return container;
    }
    private void login() {
	String name=text.getText();
	String pwd=text_1.getText();
	lm.setUsername(name);
	lm.setPwd(pwd);
	
	if((name==null||name.equals(""))&&(pwd==null||pwd.equals(""))){
	    lm.setMsg("用户名和密码不能为空");
	    return;
	}
	
	if(name.equals("admin")&&pwd.equals("admin")){
	    System.out.println("true");
	    lm.setMsg("登陆成功");
	}else{
	    System.out.println("false");
	    lm.setMsg("登陆失败");
	}
	this.getShell().redraw();
	System.out.println("LOGIN"+name+"============="+pwd+"====="+lm.getMsg());
	
    }
    
    //Dialog天生带的两个按钮不错，但我们有的时候并不想要这两个按钮,去掉它去掉,覆写这个方法，里边什么也不写
    protected void createButtonsForButtonBar(Composite parent) {
    }
    
    
    public static void main(String[] args) {
    	Display display = Display.getDefault();
    	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
    		public void run() {
    			Shell shell=new Shell(Display.getDefault(), SWT.ON_TOP | SWT.MIN);
    			Dialog d= new Login(shell);
    			d.open();
    			Display.getCurrent().dispose();
    		}
    	});
    }
    public LoginModol getLm() {
        return lm;
    }
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue usernameLmObserveValue = BeanProperties.value("username").observe(lm);
		bindingContext.bindValue(observeTextTextObserveWidget, usernameLmObserveValue, null, null);
		//
		IObservableValue observeTextText_1ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_1);
		IObservableValue pwdLmObserveValue = BeanProperties.value("pwd").observe(lm);
		bindingContext.bindValue(observeTextText_1ObserveWidget, pwdLmObserveValue, null, null);
		//
		IObservableValue observeTextText_2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(text_2);
		IObservableValue msgLmObserveValue = BeanProperties.value("msg").observe(lm);
		bindingContext.bindValue(observeTextText_2ObserveWidget, msgLmObserveValue, null, null);
		//
		return bindingContext;
	}
}
