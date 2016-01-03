package com.homework;

/**
 * Created by zn on 2015/12/31.
 * 帐号类
 */
public class Account {
    //账号名
    private String name;
    //账号密码
    private String password;
    //账号余额
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
