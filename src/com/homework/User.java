package com.homework;

/**
 * Created by zn on 2015/12/31.
 * 用户类
 */
public class User {
    //用户名
    private String name;
    //用户密码
    private String password;
    //用户邮箱
    private String email;
    //用户地址
    private String address;
    //用户性别
    private String gender;
    //用户金额
    private int money;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}