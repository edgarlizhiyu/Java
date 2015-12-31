package com.dibbling;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by pc on 2015/12/21.
 *
 */
public class Player {
    int [][] daily = new int[10][10];
    User user = new User();
    Random random = new Random();
    int randNum;
    int number;
    int choose;
    int i = 0 ;
    boolean flag = false;
    Scanner input = new Scanner(System.in);
    User [] users = new User[10];
    String [] things = {"互撸娃","8个小矮人","白血公主","罗密欧与祝英台","梁山伯与朱丽叶","提莫大闹天空" };


    public  void initial(){
        for(int i = 0; i < users.length; i ++){
            users[i] = new User();
        }
    }


    /**
     * 显示注册界面
     */
    public void showAddMenu() {
        System.out.println("***************************************************************************");
        System.out.println("                        --新用户注册--");
        System.out.println("***************************************************************************\n");
    }
    /**
     * 显示登陆界面
     */
    public void showMenu() {
        System.out.println("***************************************************************************");
        System.out.println("                      --欢迎使用 New播 智能点播平台--");
        System.out.println("***************************************************************************\n");
        System.out.println("                             1, 登陆\n");
        System.out.println("                             2，注册（送10 New 币）\n");
        System.out.println("                             3，退出\n");
        System.out.println("***************************************************************************");
        System.out.print("请选择：");
    }
    /**
     * 显示主菜单
     */
    public void showMainMenu() {
        System.out.println("*******************************************************************************************");
        System.out.println("                                  --New播 播出新生活--");
        System.out.println("*******************************************************************************************\n");
        System.out.println("1, 查询余额  2，修改密码  3，充值  4, 点播  5，查看点播日志  6，注销返回主菜单  7，退出程序\n");
        System.out.println("*******************************************************************************************");
        System.out.print("请选择：");
    }

    //注册查重
    public void register(String name,String password){
        boolean isFull = false;
        for (int i = 0; i<users.length;i++) {
            if (users[i].getName() == null) {
                isFull = false;
                break;
            } else {
                isFull = true;
            }
        }
        if (isFull) {
            User[] tempUser = users;
            users = new User[users.length * 2];
            for (int i = 0; i < tempUser.length; i++) {
                users[i] = tempUser[i];
            }
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                System.out.println("用户已存在");
                break;
            } else if (users[i].getName() == null) {
                User tempUsers = new User();
                tempUsers.register(name, password);
                users[i] = tempUsers;
                break;
            }
        }
    }


    //登陆
    public int login(String name,String password){
        for(int i = 0; i < users.length;i++) {
            if (users[i].getName()!=null && users[i].getPassword() !=null && name.equals(users[i].getName()) && password.equals(users[i].getPassword())) {
                return i;
            }else{
                if (i == users.length - 1) {
                    System.out.println("用户名或密码错误");
                } else {
                    System.out.print("");
                }
            }

        }
        return -1;
    }
    /**
     * 查询余额功能
     *
     */
    public void checkMoney(int index){
        do {
            System.out.println("当前余额：" + users[index].getMoney());
            System.out.println("继续查询请输入0 否则返回上一级菜单");
            choose = input.nextInt();
            if(choose == 0){
                flag = true;
            }else{
                flag = false;
            }
        }while (flag);
    }



    /**
     * 充值功能
     * @param money 充值金额
     */
    public void addMoney(int index,int money){
        do {
            if (0 <= money) {
                System.out.println("你充值的金额：" + money);
                users[index].setMoney(users[index].getMoney() + money);
                System.out.println("当前余额为：" + users[index].getMoney());
            } else {
                System.out.println("请输入正确的金额！");
            }
            System.out.println("继续充值请输入0 否则返回上一级菜单");
            choose = input.nextInt();
            if(choose == 0){
                flag = true;
            }else{
                flag = false;
            }
        }while (flag);
    }

    public void changePassword(int index,String oldPassword,String newPassword,String newPasswordAgain){
        do {
            if (users[index].getPassword().equals(oldPassword)) {
                if (newPassword.equals(newPasswordAgain)) {
                    users[index].setPassword(newPassword);
                    System.out.println("修改成功，请重新登录");
                } else {
                    System.out.println("两次输入密码不一致！");
                }
            } else {
                System.out.println("密码错误");
            }
            System.out.println("继续修改请输入0 否则返回上一级菜单");
            choose = input.nextInt();
            if(choose == 0){
                flag = true;
            }else{
                flag = false;
            }
        }while (flag);
    }

    /**
     * 点播功能
     */
    public void Things(int index) {
        do {
            randNum = random.nextInt(things.length);
            number = (randNum + 1);
            users[index].setMoney(users[index].getMoney() - number);
            if (users[index].getMoney() > 0) {
                System.out.println("你点播的是" + things[randNum] + "消耗" + number + "New币" + "请慢慢欣赏！");
                //点播日志提取数据
                daily[index][i] = randNum;
                i++;
            } else {
                System.out.println("余额不足请及时充值！");
                //优化余额变成负数
                users[index].setMoney(users[index].getMoney() + number);
            }
            System.out.println("继续点播请输入0 否则返回上一级菜单");
            choose = input.nextInt();
            if(choose == 0){
                flag = true;
            }else{
                flag = false;
            }
        }while (flag);
    }
    public void daily(int index){
        do {
            for (int j = 0; j < i; j++) {
                System.out.println("第" + (j + 1) + "次点播节目为\t" + things[daily[index][j]]);
            }
            System.out.println("继续查询请输入0 否则返回上一级菜单");
            choose = input.nextInt();
            if (choose == 0) {
                flag = true;
            } else {
                flag = false;
            }
        }while (flag);
    }

}
