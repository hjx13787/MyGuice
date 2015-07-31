package com.test.myguice;

import sys.my.pro.ui.manage.BasicJavaBeanModel;


public class LoginModol extends BasicJavaBeanModel {
    private String username;
    private String pwd;
    private String msg;
    private String time;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        pcs.firePropertyChange("username", null, null);
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
        pcs.firePropertyChange("pwd", null, null);
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
	this.msg=msg;
        pcs.firePropertyChange("msg", null,  null);
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        pcs.firePropertyChange("time", this.time, this.time = time);
    }
    
    
    
}
