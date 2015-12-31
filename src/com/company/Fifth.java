package com.company;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/14.
 */
public class Fifth {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score =input.nextInt();
        //不同的判定条件下 分别输出的内容
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
        }
    }
}
