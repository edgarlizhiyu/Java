package com.c8;

/**
 * Created by zn on 2015/12/22.
 */
public class User {
    private String name;
    private String password;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String toString() {
        return "name:" + name + ",password:" + password + ",gender:" + gender;
    }


}
