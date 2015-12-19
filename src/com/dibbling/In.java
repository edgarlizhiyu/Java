package com.dibbling;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/15.
 *注册类的定义
 * 至多注册10名用户
 */
public class In {
    Scanner input = new Scanner(System.in);
    User customer = new User();
    int time = 0;

    public void show() {
        System.out.println("***************************************************************************");
        System.out.println("                        --新用户注册--");
        System.out.println("***************************************************************************\n");
        System.out.print("请输入用户名：");
        name[time] = input.next();
        System.out.println();
        System.out.print("请输入密码：");
        password[time] = input.next();
        money[time] = 10;
        System.out.println();
        System.out.println("\n你的用户名：" + name[time] + "\t你的密码：" + password[time] + "\n");
        time++;
        System.out.println("注册赠送10 New 币.........");
    }
}