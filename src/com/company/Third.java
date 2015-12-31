package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Third {
     public static void main (String [] args){
         Scanner input = new Scanner(System.in);
         int a= 0;
         int b= 0;
         int c= 0;
         int number;
         System.out.println("请输入第一个数：");
         a = input.nextInt();
         System.out.println("请输入第二个数：");
         b = input.nextInt();
         System.out.println("请输入第三个数：");
         c = input.nextInt();
        //比较ab 的大小 如果a 大 则交换位置
         if ( a > b) {
            number = a;
            a = b;
            b = number;
         }
         //比较ac 的大小如果a大则交换位置
         else if (a > c) {
            number = a;
            a = c;
            c = number;
         }
         //比较bc 大小如果b大则交换位置
         if ( b > c) {
            number = b;
            b = c;
            c = number;
         }
         System.out.print(a+"\t"+b+"\t"+c);

     }

}
