package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Sixth {
    public static void main (String [] args){
       //创建入口
        Scanner input = new Scanner (System.in);
        System.out.println("请输入一个不大于5位的整数");
        int number = input.nextInt();
       //分别取得每位数的 数值
        int a = number / 1000;
        int b = number %1000/100;
        int c = number %100/10;
        int d = number %10;
       //判定用户是否根据提示输入一个不大于5位的数
        if (0<= number&&number <= 9999) {
            //判定是否是4位数
            if ((1000 <= number)&&(number <= 9999)) {
                System.out.println("你输入的四位数的每一位分别是：");
                System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
            }
           //判定是否是3位数
            if ((100 <= number)&&(number <= 999)) {
                System.out.println("你输入的三位数的每一位分别是：");
                System.out.println(b+"\t"+c+"\t"+d);
            }
            //判定是否是两位数
            if ((10 <= number)&&(number <= 99)) {
                System.out.println("你输入的两位数的每一位分别是：");
                System.out.println(c+"\t"+d);
            }
            //判定是否是一位数
            if ((0 <= number)&&(number <= 9)) {
                System.out.println("你输入的一位数的每一位分别是：");
                System.out.println(d);
            }
        }else {
            System.out.println("输入有误！");
        }
    }
}
