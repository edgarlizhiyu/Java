package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Favorable {
    public static void main(String [] arge) {
        int number = 0;
        int money = 0;
        byte choose = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入消费金额：");
       //确定输入的金额是正确的类型
        if (input.hasNextInt()){
            number = input.nextInt();
        }else{
            System.out.println("输入有误！");
        }
        //满50   +2 换可乐
        if (number >=50 && number < 100){
            System.out.println("1:消费满50元，加2元换购百事可乐饮料1瓶");
            System.out.println("0:不换购");
            System.out.println("请选择：");
            choose = input.nextByte();
            switch (choose){
                case 1:
                    money = number +2;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：百事可乐饮料1瓶");
                    break;
                default:
                    money = number;
                    System.out.print("本次消费总金额："+money+"\n");
                    break;
            }

        }
        //满100  +3 换可乐 或 +10 换面粉
        if (number >= 100 && number < 200) {
            System.out.println("1:消费满50元，加2元换购百事可乐饮料1瓶");
            System.out.println("2:消费满100元，加3元换购500ml可乐1瓶");
            System.out.println("3:消费满100元，加10元换购5公斤面粉");
            System.out.println("0:不换购");
            System.out.println("请选择：");
            choose = input.nextByte();
            switch (choose){
                case 1:
                    money = number +2;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：百事可乐饮料1瓶");
                    break;
                case 2:
                    money = number +3;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：500ml可乐1瓶");
                    break;
                case 3:
                    money = number +10;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：5公斤面粉");
                    break;
                default:
                    money = number;
                    System.out.print("本次消费总金额："+money+"\n");
                    break;
            }
        }
        //满200  +10 换锅  或 +20 换爽肤水
        if (number >= 200){
            System.out.println("1:消费满50元，加2元换购百事可乐饮料1瓶");
            System.out.println("2:消费满100元，加3元换购500ml可乐1瓶");
            System.out.println("3:消费满100元，加10元换购5公斤面粉");
            System.out.println("4:消费满200元，加10元换购苏泊尔炒菜锅");
            System.out.println("5:消费满200元，加20元换购欧莱雅爽肤水");
            System.out.println("0:不换购");
            System.out.println("请选择：");
            choose = input.nextByte();
            switch (choose){
                case 1:
                    money = number +2;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：百事可乐饮料1瓶");
                    break;
                case 2:
                    money = number +3;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：500ml可乐1瓶");
                    break;
                case 3:
                    money = number +10;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：5公斤面粉");
                    break;
                case 4:
                    money = number +10;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：1个苏泊尔炒菜锅");
                    break;
                case 5:
                    money = number +20;
                    System.out.print("本次消费总金额："+money+"\n");
                    System.out.print("成功换购：欧莱雅爽肤水");
                    break;
                default:
                    money = number;
                    System.out.print("本次消费总金额："+money+"\n");
                    break;
            }
        }
    }
}
