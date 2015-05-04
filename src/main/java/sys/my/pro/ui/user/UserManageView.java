package sys.my.pro.ui.user;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class UserManageView extends Composite {

    public UserManageView(Composite parent, int style) {
	super(parent, style);
	
	Label lblNewLabel = new Label(this, SWT.NONE);
	lblNewLabel.setBounds(98, 93, 61, 17);
	lblNewLabel.setText("系统");
	
	Label lblNewLabel_1 = new Label(this, SWT.NONE);
	lblNewLabel_1.setBounds(84, 212, 61, 17);
	lblNewLabel_1.setText("New Label");
	// TODO 自动生成的构造函数存根
    }
}
