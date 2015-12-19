package com.dibbling;

import java.util.Random;

/**
 * Created by pc on 2015/12/16.
 * 点播库设定
 */
public class Things {
    String [] things = {"葫芦娃","8个小矮人","白血公主","罗密欧与祝英台","梁山伯与朱丽叶" };
    Random random = new Random();
    int number;
    int randNum;
    public void rand (){
        randNum =  random.nextInt(things.length);
        number =  (randNum+1);
    }
    public void show(){
        System.out.println("你点播的是"+things[randNum]+"消耗"+number+"New币"+"请慢慢欣赏！");
    }
}
