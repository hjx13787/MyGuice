package com.test.myguice;


public class LoginModol extends BasicJavaBeanModel {
    private String username;
    private String pwd;
    private String msg;
    
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
    
    
    
}
