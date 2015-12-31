package com.company;
import java.util.Arrays;
import java.util.Scanner;
/**
 *”==”和”=”的区别
 * == 是恒等 表示一个变量是否等于这个值
 * =  是赋值 表示把一个值赋给这个变量
 */
public class HomeWork {
    public static void main (String [] args) {
        //第二题
        /*byte age =7;
        String gender = "女";
        if (age >= 7 || (age >= 5 && gender.equals("男"))) {
            System.out.println("速速来当苦力搬桌子");
        }else {
            System.out.println("小不点一边站");
        }*/

        //第三题
       /* Scanner input = new Scanner (System.in);
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
        if ( a > b) {
            number = a;
            a = b;
            b = number;
        }else if (a > c) {
            number = a;
            a = c;
            c = number;
        }
        if ( b > c) {
            number = b;
            b = c;
            c = number;
        }
        System.out.print(a+"\t"+b+"\t"+c);*/

        //第四题
        /*Scanner input = new Scanner (System.in);
        System.out.println("请输入一个整数：");
        int number = input.nextInt();
        if ( number % 3 ==0 || number % 5 == 0) {
            System.out.println("该整数是3或5的倍数");
        }else {
            System.out.println("该整数不是3或5的倍数");
        }*/

        //第五题
        /*Scanner input = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score =input.nextInt();
        if (score == 100){
            System.out.println("父亲给她买辆车");
        }
        if ((score >= 90 && score <100)) {
            System.out.println("母亲给她买台笔记本电脑");
        }
        if ((score >= 60 && score <90)){
            System.out.println("母亲给她买部手机");
        }
        if (score < 60){
            System.out.println("滚去念书");
        }*/

        //第六题
        Scanner input = new Scanner (System.in);
        System.out.println("请输入一个不大于5位的整数");
        int number = input.nextInt();
        int a = number / 1000;
        int b = number %1000/100;
        int c = number %100/10;
        int d = number %10;
        if (number < 9999) {
            if ((1000 <= number)&&(number <= 9999)) {
                System.out.println("你输入的四位数的每一位分别是：");
                System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
            }
            if ((100 <= number)&&(number <= 999)) {
                System.out.println("你输入的三位数的每一位分别是：");
                System.out.println(b+"\t"+c+"\t"+d);
            }
            if ((10 <= number)&&(number <= 99)) {
                System.out.println("你输入的两位数的每一位分别是：");
                System.out.println(c+"\t"+d);
            }
            if ((0 <= number)&&(number <= 9)) {
                System.out.println("你输入的一位数的每一位分别是：");
                System.out.println(d);
            }
        }else {
            System.out.println("输入有误！");
        }
    }
}
