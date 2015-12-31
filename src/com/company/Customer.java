package com.company;
import java.util.*;
/**
 * Created by pc on 2015/12/14.
 */
public class Customer {
    public static void main(String [] args){
        int number= 0;
        String date= "";
        int point= 0;
        Scanner input = new Scanner (System.in);
        System.out.println("我行我素购物管理系统 > 客户信息管理 > 添加客户信息\n\n");
        System.out.print("请输入会员号<4位整数>:");
       //判断接收的值是否跟定义的变量类型一致
        if (input.hasNextInt()) {
             number = input.nextInt();
        }
        else{
            System.out.println("输入有误");
        }
        System.out.print("请输入会员生日(月/日<用两位数表示>):");
        if (input.hasNext()) {
             date = input.next();
        }
        else{
            System.out.println("输入有误");
        }
        System.out.print("请输入积分:");
        if (input.hasNextInt()) {
             point = input.nextInt();
        }
        else{
            System.out.println("输入有误");
        }
        System.out.println("以录入的会员信息是：");
        System.out.println(number+"\t"+date+"\t"+point);
    }
}
