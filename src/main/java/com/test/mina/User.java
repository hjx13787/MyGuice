package com.test.mina;

import java.util.UUID;

public class User {
    private String id=UUID.randomUUID().toString();
    
    private String name;
    private String pwd;
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
