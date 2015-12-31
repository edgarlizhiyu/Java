package com.test;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/24.
 */
public class Math {
    Scanner input = new Scanner(System.in);
    //标准计算器
    public void add() {
        int number = 0;
        int sum=0;
        String choose = "";
        System.out.println("请输入一个数：");
        sum = input.nextInt();
        do{
            System.out.println("请输入运算符：");
            choose = input.next();
            if(!choose.equals("=")) {
                System.out.println("请输入一个数：");
                number = input.nextInt();
            }
            if (choose.equals("+")) {
                sum += number;
            } else if (choose.equals("-")) {
                sum -= number;
            } else if (choose.equals("*")) {
                sum *= number;
            } else if (choose.equals("/")) {
                sum /= number;
            }
        }while (!choose.equals("="));

        System.out.println("计算结果--->"+sum);
    }
    //某数的幂
        public void mi(){
        System.out.println("请输入一个数：");
        int numberA = input.nextInt();
        System.out.println("请输入这个数的幂：");
        int numberB = input.nextInt();
        int sum = numberA;
        for(int i = 0 ; i <numberB-1;i++){
            sum *= numberA;
        }
        System.out.println("计算结果--->"+sum);
    }

}
