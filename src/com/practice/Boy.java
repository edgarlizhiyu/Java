package com.practice;

/**
 * Created by pc on 2015/12/25.
 */
public class Boy extends Person{
    String name = "1";
    int age = 1;
    public Boy(){
        super("123",15);
        System.out.println(super.name+super.age);
    }
}
