package sys.my.pro.ui.composite;

import sys.my.pro.ui.manage.BasicJavaBeanModel;

public class TbModel extends BasicJavaBeanModel {
    String name;
    String id;
    String pwd;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        pcs.firePropertyChange("name", this.name, this.name = name);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        pcs.firePropertyChange("id", this.id, this.id = id);
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        pcs.firePropertyChange("pwd", this.pwd, this.pwd = pwd);
    }
    
}
