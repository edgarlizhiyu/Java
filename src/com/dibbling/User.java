package com.dibbling;

/**
 * Created by pc on 2015/12/18.
 */
public class User {
    //用户数组
    public static String names ;
    //密码数组
    public static String [] passwords = new String[10];
    //钱
    public static int [] money = new int[10];
    //点播日志
    public static String [] daily = new String[10];
    /**
     * 注册操作
     * @param name       注册的用户名
     * @param password  注册的密码
     */
    public static void register(String name,String password){
        boolean isFull = false;
        for (String s : names) {
            if (s == null){
                isFull = false;
            }else{
                isFull = true;
            }
        }
        if (isFull){
            String [] tempNames = names;
            String [] temppasswords = passwords;
            String [] tempdaily = daily;
            int [] tempmoney = money;
            names = new String[tempNames.length*2];
            passwords = new String[temppasswords.length*2];
            money = new int[tempmoney.length*2];
            daily = new String[tempdaily.length*2];
            for(int i = 0 ;i < tempNames.length; i++){
                names[i] = tempNames[i];
                passwords[i]=temppasswords[i];
                money[i]=tempmoney[i];
                daily[i] = tempdaily[i];
            }
        }
        for(int i = 0;i < names.length;i++){
            if(names[i]==null){
                names[i] = name;
                passwords[i] = password;
                money[i]=10;
                break;
            }
        }
    }
}
