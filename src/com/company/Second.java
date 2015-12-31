package com.company;
import java.util.*;
/**
 * Created by pc on 2015/12/14.
 */
public class Second {
     public static void main(String [] args) {
        //创建接收入口
         Scanner input = new Scanner(System.in);
         byte age = 0;
         String gender ="";
         System.out.println("请输入年龄：");
         age = input.nextByte();
         System.out.println("请输入性别（男/女）：");
         gender = input.next();
        //对条件进行判定并输出不同语句
         if (age >= 7 || (age >= 5 && gender.equals("男"))) {
             System.out.println("速速来当苦力搬桌子");
         } else {
             System.out.println("小不点一边站");
         }
     }
}
