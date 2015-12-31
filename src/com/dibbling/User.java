package com.dibbling;

/**
 * Created by pc on 2015/12/18.
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    //注册
    public void register(String name,String password){
        this.name = name;
        this.password = password;
        setMoney(10);
        System.out.println("\n你的用户名：" + this.getName() + "\t你的密码：" + this.getPassword() + "\n"+ "\t你的余额：" + this.getMoney());
    }
}
