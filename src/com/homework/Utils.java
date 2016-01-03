package com.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zn on 2015/12/31.
 */
public class Utils {
    /**
     * 判断一个字符是否为null或空内容
     * 示例：
     * Utils.isBlank("ok")  false
     * Utils.isBlank("")    true;
     * Utils.isBlank("    ")    true
     * Utils.isBlank(null)  true
     * Utils.isBlank("  ok  ")  false
     * Utils.isBlank("o  k")    false;
     *
     * @param str 需要判断的字符串
     * @return 如果str为null或空值或多个空格符，否返回为true，否则返回为false
     */
    public static boolean isBlank(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] != 0) && (ch[i] != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断传入的字符串是否为boolean
     * 部分示例：
     * Utils.isBoolean("true"); true;
     * Utils.isBoolean("false"); false;
     * Utils.isBoolean("yes"); true;
     * Utils.isBoolean("no"); false;
     * Utils.isBoolean(null); false
     * Utils.isBoolean(""); false;
     * Utils.isBoolean("    "); false;
     * Utils.isBoolean("true  "); true;
     * Utils.isBoolean("  true"); true;
     * Utils.isBoolean("  true  "); true;
     * Utils.isBoolean("abc"); false;
     *
     * @param str
     * @return
     */
    public static boolean isBoolean(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] == 't' && ch[i + 1] == 'r' && ch[i + 2] == 'u' && ch[i + 3] == 'e') || (ch[i] == 'y' && ch[i + 1] == 'e' && ch[i + 2] == 's') ||
                    (ch[i] == 'T' && ch[i + 1] == 'R' && ch[i + 2] == 'U' && ch[i + 3] == 'E') || (ch[i] == 'Y' && ch[i + 1] == 'E' && ch[i + 2] == 'S')) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是数字，包含正负数
     *
     * @param str
     * @return
     */
    public static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否是浮点数
     *
     * @param str
     * @return
     */
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            if (str.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断是否是正确的电子邮件格式(选作)
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();


    }

    public void registerAccount(int index,Account [][] account,String name, String password,int money) {
//        boolean isFull = false;
//        for (int i = 0; i < account.length; i++) {
//            if (account[i].getName() == null) {
//                isFull = false;
//                break;
//            } else {
//                isFull = true;
//            }
//        }
//        if (isFull) {
//            Account[] tempAccount = account;
//            account = new Account[account.length * 2];
//            for (int i = 0; i < tempAccount.length; i++) {
//                account[i] = tempAccount[i];
//            }
//        }

            for(int j = 0 ; j < account[index].length; j ++) {
                if (account[index] != null && name.equals(account[index][j].getName())) {
                    System.out.println("用户已存在");
                    break;
                } else if (account[index][j].getName() == null) {
                    Account tempAccount = new Account();
                    tempAccount.setName(name);
                    tempAccount.setPassword(password);
                    tempAccount.setMoney(money);
                    account[index][j]= tempAccount;
                    break;
                }
            }

    }
    /**
     * 用户注册功能
     * 检查注册是否重复 用户数组是否已满
     *
     * @param users    用户数组
     * @param name     用户名
     * @param password 用户密码
     */
    public void register(User[] users, String name, String password,String gender,String address) {
        boolean isFull = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName() == null) {
                isFull = false;
                break;
            } else {
                isFull = true;
            }
        }
        if (isFull) {
            User[] tempUser = users;
            users = new User[users.length * 2];
            for (int i = 0; i < tempUser.length; i++) {
                users[i] = tempUser[i];
            }
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                System.out.println("用户已存在");
                break;
            } else if (users[i].getName() == null) {
                User tempUsers = new User();
                tempUsers.setName(name);
                tempUsers.setPassword(password);
                tempUsers.setGender(gender);
                tempUsers.setAddress(address);
                tempUsers.setMoney(10);
                users[i] = tempUsers;
                showMessage("你的用户名为："+users[i].getName()+"\n"+"你的密码为："+users[i].getPassword()+"\n");
                break;
            }
        }
    }

    /**
     * 验证登陆是否成功，成功返回数组索引否则返回-1
     *
     * @param users    用户数组
     * @param name     用户名
     * @param password 用户密码
     * @return 登陆成功返回数组索引  失败返回-1
     */
    public int login(User[] users, String name, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName() != null && users[i].getPassword() != null && name.equals(users[i].getName()) && password.equals(users[i].getPassword())) {
                return i;
            } else {
                if (i == users.length - 1) {
                    System.out.println("用户名或密码错误");
                } else {
                    System.out.print("");
                }
            }

        }
        return -1;
    }
    /**
     * 添加电影
     * @param items  电影数组
     * @param item   电影对象
     */
    public void addItem(Item[] items,Item item) {
        boolean isFull = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() == null) {
                isFull = false;
                break;
            } else {
                isFull = true;
            }
        }
        if (isFull) {
            Item[] tempItem = items;
            items = new Item[items.length * 2];
            for (int i = 0; i < tempItem.length; i++) {
                items[i] = tempItem[i];
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() == null) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * 封装输出指令
     *
     * @param str 输出的内容
     */
    public void showMessage(String str) {
        System.out.print(str);
    }
}