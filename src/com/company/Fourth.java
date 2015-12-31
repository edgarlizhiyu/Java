package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Fourth {
    public static void main (String [] args){
        //创建一个接收入口
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number = input.nextInt();
        //对3 跟 5 的模 进行判定分别输入语句
        if ( number % 3 ==0 || number % 5 == 0) {
            System.out.println("该整数是3或5的倍数");
        }else {
            System.out.println("该整数不是3或5的倍数");
        }
    }
}
