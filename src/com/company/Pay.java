package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Pay {
    public static void main (String [] arge) {
        int number = 0;
        double money = 0.0;
        String str;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入是否是会员：Y/N");
       //判断输入类型是否一致
        if (input.hasNext()) {
            str = input.next();
            System.out.println("请输入购物金额");
            number = input.nextInt();
            //判断是否是会员是否达到消费标准
            if (str.equals("y") && number >=200){
                money = number*0.75;
            }else if (str.equals("y") && number >=100){
                money = number*0.8;
            }
            if (str.equals("n") && number >=100) {
                money = number * 0.9;
            }
        }else {
            System.out.println("输入有误！");
        }
        System.out.println("实际支付:"+money);
    }
}
