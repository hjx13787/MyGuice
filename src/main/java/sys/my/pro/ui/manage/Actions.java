package sys.my.pro.ui.manage;

import java.util.List;

import org.eclipse.jface.action.Action;

public class Actions {
    private List<Action> list;
    public Actions(List<Action> list) {
	this.list=list;
    }
    public List<Action> getList() {
	return list;
    }
    
}
