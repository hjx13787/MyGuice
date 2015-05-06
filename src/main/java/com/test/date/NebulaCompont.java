package com.test.date;
 
import java.util.Locale;
 
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.datechooser.DateChooser;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.nebula.widgets.datechooser.DateChooserTheme;
import org.eclipse.nebula.widgets.formattedtext.DateFormatter;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridColumnGroup;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.nebula.widgets.pgroup.FormGroupStrategy;
import org.eclipse.nebula.widgets.pgroup.MinMaxToggleRenderer;
import org.eclipse.nebula.widgets.pgroup.PGroup;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.nebula.widgets.radiogroup.RadioItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
 
import com.easyway.tbs.commons.ext.nebula.NebulasView;
 
public class NebulaCompont {
 /**
  * 创建RadioGroup
  * @param parent
  * @return
  */
   public Control createRadioGroup(Composite parent)
     {
    RadioGroup  radioGroup = new RadioGroup(parent, SWT.FLAT);
         (new RadioItem(radioGroup, 0)).setText("Red");
         (new RadioItem(radioGroup, 0)).setText("Orange");
         (new RadioItem(radioGroup, 0)).setText("Yellow");
         (new RadioItem(radioGroup, 0)).setText("Green");
         (new RadioItem(radioGroup, 0)).setText("Blue");
         (new RadioItem(radioGroup, 0)).setText("Indigo");
         (new RadioItem(radioGroup, 0)).setText("Violet");
         return radioGroup;
     }
   /**
    * 创建CDateTime
    * @param parent
    * @param style
    * @param format
    * @param pattern
    * @return
    */
   public Control createCDateTime(Composite parent,int style,int format,String pattern)
   {
    CDateTime  cdc = new CDateTime(parent, style);
    cdc.setLocale(Locale.CHINESE);
    cdc.setFormat(format);
    cdc.setPattern(pattern);
    return cdc;
   }
   /**
    *创建 DateChooserCombo
    * @param parent
    * @param style
    * @return
    */
   public Control createDateChooserCombo(Composite parent,int style)
   {
    DateChooserCombo chooserCombo = new DateChooserCombo(parent, style);
    chooserCombo.setTheme(DateChooserTheme.YELLOW);
       chooserCombo.setFooterVisible(true);
       chooserCombo.setFormatter(new DateFormatter("yyyy-MM-dd",Locale.CHINESE));
       return chooserCombo;
   }
   /**
    *创建 DateChooser
    * @param parent
    * @param style
    * @return
    */
   public Control createDateChooser(Composite parent,int style)
     {
      DateChooser  chooser = new DateChooser(parent, style);
      chooser.setTheme(DateChooserTheme.YELLOW);
         chooser.setWeeksVisible(true);
         chooser.setFooterVisible(true);
         chooser.setNavigationEnabled(true);
         chooser.setAutoChangeOnAdjacent(true);
         chooser.setAutoSelectOnFooter(true);
         return chooser;
     }
   public Control createsDateChooser(Composite parent,int style)
     {
      DateChooser  chooser = new DateChooser(parent, style);
      chooser.setTheme(DateChooserTheme.YELLOW);
         chooser.setWeeksVisible(true);
         chooser.setFooterVisible(true);
         chooser.setNavigationEnabled(true);
         chooser.setAutoChangeOnAdjacent(true);
         chooser.setAutoSelectOnFooter(true);
         return chooser;
     }
   /**
    *创建 PGroup  (典型应用类似QQ中设置的效果)
    * @param parent
    * @return
    */
   public Control createPGroup(Composite parent,int style)
     {
         PGroup group = new PGroup(parent, style);
         group.setStrategy(new FormGroupStrategy());
         group.setToggleRenderer(new MinMaxToggleRenderer());
         group.setText("PGroup学习应用");
         group.setImage(NebulasView.getImage("icons/woman3.png"));
         group.setLayout(new GridLayout(3, false));
         Button b = new Button(group, 8);
         b.setText("Button 1");
         b = new Button(group, 8);
         b.setText("Button 22222");
         b = new Button(group, 8);
         b.setText("Button 3");
         return group;
     }
   /**
     *创建 Grid
    * @param parent
    * @param style
    * @return
    */
   public Control createGrid(Composite parent,int style)
     {
         Grid  grid = new Grid(parent, style);
         grid.setHeaderVisible(true);
         GridColumn col = new GridColumn(grid, 0);
         col.setTree(true);
         col.setText("First Column");
         col.setWidth(140);
         GridColumnGroup group = new GridColumnGroup(grid, SWT.BORDER);
         group.setText("Column Grouping");
         GridColumn col2 = new GridColumn(group, SWT.CENTER);
         col2.setText("The Column #2");
         col2.setWidth(230);
         col2.setResizeable(false);
         final GridColumn col3 = new GridColumn(group, 0);
         col3.setSummary(false);
         col3.setText("Click me");
         col3.setWidth(100);
         col3.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent e)
             {
                 if(col3.getSort() == 128)
                     col3.setSort(1024);
                 else
                     col3.setSort(128);
             }
         }
         );
         GridItem item = new GridItem(grid, 0);
         item.setText("Item #000000000000000000000");
         item.setText(1, "Test data ");
         item.setText(2, "asdfjas;dlfjk");
         item.setColumnSpan(2, 1);
         item.setImage(NebulasView.getImage("icons/eclipse.png"));
         item.setToolTipText(0, "my tooltip 1");
         item.setToolTipText(1, "tooltip2");
         item.setToolTipText(2, "test tooltip on 3");
         GridItem item2 = new GridItem(item, 0);
         item2.setText("first tree");
         item2.setText(1, "first tree");
         item2.setToolTipText(0, "hi");
         item2.setToolTipText(1, "more tooltips");
         item2 = new GridItem(item, 0);
         item2.setText("first tree");
         item2.setText(1, "first tree");
         item2 = new GridItem(item, 0, 0);
         item2.setText("should be 1111");
         item2.setText(1, "first tree");
         GridItem item22 = new GridItem(item2, 0);
         item22.setText("second tree");
         item22.setText(1, "this is a readonly checkbox (if SWT.CHECK)");
         item22.setChecked(1, true);
         item22.setGrayed(1, true);
         item22.setCheckable(1, false);
         GridItem item55 = new GridItem(grid, 0);
         item55.setText("Item #55");
         item55.setText(1, "This cell spans over many columns, use setColumnSpan method to achieve this");
         item55.setChecked(1, true);
         item55.setColumnSpan(1, 2);
         GridItem item52 = new GridItem(item55, 0);
         item52.setText("second tree");
         item52.setText(1, "second tree");
         for(int i = 3; i < 13; i++)
         {
             GridItem item3 = new GridItem(grid, 0);
             item3.setText("Item #" + i);
             item3.setText(1, "Test data ");
             item3.setText(2, "asdfjas;dlfjk");
             if(i == 5)
             {
                 Font f = new Font(Display.getCurrent(), "Tahoma", 8, 3);
                 item3.setFont(2, f);
                 item3.setForeground(2, Display.getCurrent().getSystemColor(12));
             }
         }
 
         GridColumn col4 = new GridColumn(grid, 0);
         col4.setText("4th col");
         col4.setWidth(50);
         grid.setRowHeaderVisible(true);
         grid.setHeaderVisible(true);
         grid.setLinesVisible(true);
         grid.setColumnScrolling(true);
         for(int i = 0; i < grid.getColumns().length; i++)
         {
             grid.getColumn(i).setMoveable(true);
          grid.getColumn(i).setResizeable(true);
         }
 

         grid.setSelectionEnabled(true);
         grid.setCellSelectionEnabled(true);
         grid.getColumn(1).setCellSelectionEnabled(true);
         grid.getColumn(1).setWordWrap(true);
         grid.setRowsResizeable(true);
         return grid;
     }
   public static void main(String[] args) {
  
    Display display=Display.getDefault();
    Shell shell=new Shell(display);
   
    RadioGroup  radioGroup = new RadioGroup(shell, SWT.LEFT);
         (new RadioItem(radioGroup, 0)).setText("Red");
         (new RadioItem(radioGroup, 0)).setText("Orange");
         (new RadioItem(radioGroup, 0)).setText("Yellow");
         (new RadioItem(radioGroup, 0)).setText("Green");
         (new RadioItem(radioGroup, 0)).setText("Blue");
         (new RadioItem(radioGroup, 0)).setText("Indigo");
         (new RadioItem(radioGroup, 0)).setText("Violet");
         radioGroup.setSize(400,450);
         //获取数据单选按钮
         radioGroup.getSelection().getData();
         
         shell.open();
         
      while(!display.isDisposed())
   {
     if(!display.readAndDispatch())
     {
      display.sleep();
     }
   }
   
   display.dispose();
 }
}
