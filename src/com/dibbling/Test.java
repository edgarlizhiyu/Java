package com.dibbling;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pc on 2015/12/21.
 * 对象数组还未弄明白 所以一些功能尚有BUG
 */
public class Test {
    public static void main(String[] args) {
        String name = "";
        String password = "";
        boolean flag = false;
        boolean toMenu = false;
        boolean toMainMenu = false;
        int choose = 0;
        int number = -1;
        int index;
        User[] users = new User[10];
        Scanner input = new Scanner(System.in);
        User user = new User();
        Player player = new Player();
        player.initial();

        do {
            player.showMenu();
            if (input.hasNextByte()) {
                do {
                    choose = input.nextByte();
                    if ((1 <= choose && choose <= 3)) {
                        flag = true;
                    } else {
                        System.out.println("选择错误，并没有此选项！" + "\n请重新选择：");
                        flag = false;
                    }
                } while (false);
            } else {
                System.out.println("操作错误程序退出！");
            }
            do {

                switch (choose) {
                    case 1:
                        System.out.println("请输入用户名：");
                        name = input.next();
                        System.out.println("请输入密码：");
                        password = input.next();
                        index = player.login(name,password);
                            if (index >= 0) {
                                do {
                                    player.showMainMenu();
                                    if (input.hasNextByte()) {
                                        do {
                                            choose = input.nextByte();
                                            if ((1 <= choose && choose <= 7)) {
                                                flag = true;
                                            } else {
                                                System.out.println("选择错误，并没有此选项！" + "\n请重新选择：");
                                                flag = false;
                                            }
                                        } while (false);
                                    } else {
                                        System.out.println("操作错误程序退出！");
                                    }
                                    switch (choose) {
                                        case 1:
                                            player.checkMoney(index);
                                            System.out.println("输入0返回主菜单");
                                            number = input.nextInt();
                                            if (number == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("请输入原始密码：");
                                            String oldPassword = input.next();
                                            System.out.println("请输入新密码：");
                                            String newPassword = input.next();
                                            System.out.println("请再输入新密码：");
                                            String newPasswordAgain = input.next();
                                            player.changePassword(index,oldPassword,newPassword,newPasswordAgain);
                                            System.out.println("输入0返回主菜单");
                                            number = input.nextInt();
                                            if (number == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                            break;
                                        case 3:
                                            System.out.println("请输入需要充值金额：");
                                            int money = input.nextInt();
                                            player.addMoney(index,money);
                                            System.out.println("输入0返回主菜单");
                                            number = input.nextInt();
                                            if (number == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                            break;
                                        case 4:
                                           player.Things(index);

                                            if (number == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                            break;
                                        case 5:
                                            player.daily(index);
                                            System.out.println("输入0返回主菜单");
                                            number = input.nextInt();
                                            if (number == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                            break;
                                        case 6:
                                            toMainMenu = false;
                                            toMenu = true;
                                            flag = false;
                                            break;
                                        case 7:
                                            toMainMenu = false;
                                            toMenu = false;
                                            flag = false;
                                            break;
                                    }
                                } while (toMainMenu);
                            }

                        break;
                    case 2:
                        player.showAddMenu();
                        System.out.println("请输入用户名：");
                        name = input.next();
                        System.out.println("请输入密码：");
                        password = input.next();
                        player.register(name,password);
                        toMenu = true;
                        toMainMenu = false;
                        break;
                    case 3:
                        toMainMenu = false;
                        toMenu = false;
                        flag = false;
                        break;
                }
            }while (toMainMenu) ;
        } while (toMenu) ;
        System.out.println("程序退出");

    }
}

