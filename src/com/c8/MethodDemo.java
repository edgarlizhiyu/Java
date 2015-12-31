package com.c8;

import java.io.File;

/**
 * Created by zn on 2015/12/22
 * 讲解基本类型方法的使用
 */
public class MethodDemo {
    /**
     * 无参无返回
     */
    public void noParametNoReturn(){

    }
    /**
     * 无参有返回
     * @return
     */
    public int noParamHaveReturn() {
        int i = 10;
        return i;
    }
    /**
     * 有参无返回
     */
    public void haveParamNoReturn(int age) {
        age ++;
        System.out.println(age);
    }
    public int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }
    public static void main(String [] args) {
        MethodDemo demo = new MethodDemo();
        int a = 10;
        int b = 20;
        int sum = demo.sum(a,b);
        System.out.println(sum);
    }
}
