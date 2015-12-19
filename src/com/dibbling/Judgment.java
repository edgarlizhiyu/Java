package com.dibbling;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/15.
 * 定义一个判断接收的数据是否接收成功的类
 */
public class Judgment {
    Scanner input = new Scanner(System.in);
    byte number = 0;
    byte choose = 0;
    byte i = 1;
    byte j = 3;
    public void show(){
        if(input.hasNextByte()) {
            do {
                number = input.nextByte();
                if ((i <= number && number <= j)) {
                    choose = i;
                } else {
                    System.out.println("选择错误，并没有此选项！" + "\n请重新选择：");
                    choose = j;
                }
            } while (choose == j);
        }else {
            System.out.println("操作错误程序退出！");
        }
    }
}
