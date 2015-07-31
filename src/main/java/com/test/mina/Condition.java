package com.test.mina;

import java.io.Serializable;
import java.util.List;

public class Condition implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5253430457395478979L;
    
    private List<Student> students;
    private List<UserInfo> users;
    
   
    
    public List<UserInfo> getUsers() {
        return users;
    }
    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    
}
