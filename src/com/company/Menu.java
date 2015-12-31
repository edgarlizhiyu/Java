package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Menu {
    public static void main(String [] arge){
        System.out.println("我行我素购物管理系统\n");
        System.out.println("1，登录系统\n");
        System.out.println("2，退出\n");
        byte number ;
        Scanner input = new Scanner(System.in);
        System.out.print("请选择：");
        if (input.hasNextByte()){
            number = input.nextByte();
            switch (number){
                case 1:
                    System.out.println("我行我素购物管理系统\n");
                    System.out.println("1，客户信息管理\n");
                    System.out.println("2，购物结算\n");
                    System.out.println("3，真情回馈\n");
                    System.out.println("4，注销\n");
                    break;
                case 2:
                    System.out.println("程序退出谢谢使用！");
                    break;
                default:
                    System.out.println("输入有误程序结束！");
                    break;


            }
        }else {
            System.out.println("输入有误！");
        }
    }
}
