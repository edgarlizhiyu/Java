package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pc on 2015/12/21.
 */
public class Test {

    public static void main(String [] args){
        List list = new ArrayList();//顺序储存数据
        for(int i = 0 ;i < 5 ; i ++){
            list.add(i);
        }
        System.out.println(list.size());
        for(int i = 0 ;i < list.size(); i ++){
           list.remove(i);
        }
        list.clear();
        System.out.println(list.size());
    }
}
