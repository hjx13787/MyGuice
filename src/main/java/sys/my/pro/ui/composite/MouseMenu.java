package sys.my.pro.ui.composite;

import java.awt.event.ActionEvent;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;

public class MouseMenu extends ApplicationWindow {
	private DataBindingContext m_bindingContext;
    public MouseMenu(Shell parentShell) {
	super(parentShell);
    }

    private Composite main;
    private Table table_1;
    private TbModel model=new TbModel();
    private TableColumn tblclmnId;

    @Override
    protected Control createContents(Composite parent) {
	main = new Composite(parent, SWT.NONE);
	main.setLayout(new GridLayout(1, false));

	table_1 = new Table(main, SWT.BORDER | SWT.FULL_SELECTION);
	GridData gd_table_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
		1, 1);
	gd_table_1.widthHint = 411;
	gd_table_1.heightHint = 227;
	table_1.setLayoutData(gd_table_1);
	table_1.setHeaderVisible(true);
	table_1.setLinesVisible(true);

	tblclmnId = new TableColumn(table_1, SWT.NONE);
	tblclmnId.setText("id");
	tblclmnId.setWidth(100);

	TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
	tblclmnNewColumn.setWidth(100);
	tblclmnNewColumn.setText("name");

	TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
	tblclmnNewColumn_1.setWidth(100);
	tblclmnNewColumn_1.setText("pwd");
	Menu menu=new Menu(table_1);
	table_1.setMenu(menu);
	TableItem t=new TableItem(table_1,SWT.NONE);
	t.setText(new String[]{"1","name","pwd"});
	MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
	mntmNewItem.setText("new");
	
	MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
	mntmNewItem_1.setText("edit");
	
	MenuItem mntmNewItem_2 = new MenuItem(menu, SWT.NONE);
	mntmNewItem_2.setText("delete");
	m_bindingContext = initDataBindings();
	
	return super.createContents(parent);
    }

    public static void main(String[] args) {
    	Display display = Display.getDefault();
    	Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
    		public void run() {
    			MouseMenu m = new MouseMenu(null);
    			m.setBlockOnOpen(true);
    			m.open();
    			Display.getDefault().dispose();
    		}
    	});
    }
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		return bindingContext;
	}
}
