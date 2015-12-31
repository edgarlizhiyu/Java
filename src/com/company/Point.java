package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Point {
    public static void main (String [] arge){
        int point = 0;
        Scanner input = new Scanner (System.in);
        System.out.println("请输入会员积分：");
        if (input.hasNextInt()) {
            point = input.nextInt();
            if (point < 2000){
                System.out.println("该会员享受的折扣是：0.9");
            }else if (2000<=point &&point<4000){
                System.out.println("该会员享受的折扣是：0.8");
            }else if (4000<=point &&point<8000) {
                System.out.println("该会员享受的折扣是：0.7");
            }else if (8000<=point) {
                System.out.println("该会员享受的折扣是：0.6");
            }
        }else {
            System.out.println("输入有误");
        }
    }
}
