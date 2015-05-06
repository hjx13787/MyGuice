package com.test.composite;

import sys.my.pro.ui.manage.BasicJavaBeanModel;

public class TestModel extends BasicJavaBeanModel{
    public int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        pcs.firePropertyChange("name", this.name, this.name = name);
    }

    
    
    
}