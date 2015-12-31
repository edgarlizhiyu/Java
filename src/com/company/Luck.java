package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Luck {
    public static void main (String [] args){
        int number = 0;
        int c = number %100/10;
        int randNum = (int)(Math.random() * 10);
        System.out.println("我行我素购物管理系统 > 幸运抽奖\n\n");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4位会员号：");
        //判定输入是否是正确类型
        if (input.hasNextInt()){
            number = input.nextInt();
        }else {
            System.out.println("输入有误");
        }
        if (c == randNum) {
            System.out.println(number+"号客户，谢谢您的支持！");
        } else {
            System.out.println(number+"号客户是幸运客户，获精美MP3一个。");
        }
    }
}
