package com.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zn on 2015/12/14.
 * //实现单用户的点播扣费，充值等
 */
public class SimpleDemand {
    //用户数组
    private static String [] names = new String[10];
    //密码数组
    private static String [] passwords = new String[10];
    //钱
    private static int [] money = new int[10];
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
            int [] tempmoney = money;
            names = new String[tempNames.length*2];
            passwords = new String[temppasswords.length*2];
            money = new int[tempmoney.length*2];
            for(int i = 0 ;i < tempNames.length; i++){
                names[i] = tempNames[i];
                passwords[i]=temppasswords[i];
                money[i]=tempmoney[i];
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

    public static int getIndexByName(String name){
        for(int i = 0;i <names.length;i++){
            if(name != null && name.equals(names[i])){
                return i;
            }
        }
        return -1;
    }
    /**
     * 显示消息
     * @param msg 输出内容
     */
    public static void showMessage(String msg){
        System.out.print(msg);
    }

    /**
     * 显示消息换行
     * @param msg 输出内容
     */
    public static void showMessageLine(String msg){
        System.out.println(msg);
    }
    public static void main(String [] args) throws InterruptedException {
        String [] items = {"穹顶之下","泰囧","港囧","格林","危机边缘","闪电侠","神盾局",
                "神奇四侠1","神奇四侠2","新神奇四侠","代号47","蚁人","机械姬","末日崩塌","木星上行",
                "星际旅行","地球百子","暗物质","星战前传","突袭2","突袭","杀破狼","杀破狼2"};
        Scanner scanner = new Scanner(System.in);
        String menu = "1.登录    2.查询余额    3.修改密码    4.充值    5.点播    6.退出     7.查看点播日志(扩展)";
        String userName;//用户名
        String userPassword;//用户密码
        String itemName;//点播的项目名
        int price;//单次点播金额
        int select = 0;//菜单选项
        int index = -1;
        boolean isLogin = false;
        showMessage("注册即送10元Bo币!");
        while(true) {
            System.out.println("请输入账户名:");
            userName = scanner.next();
            System.out.println("请输入密码:");
            userPassword = scanner.next();
            index = getIndexByName(userName);
            if (index < 0) {
                register(userName, userPassword);
                index = getIndexByName(userName);
                showMessageLine(Arrays.toString(names));
                showMessageLine(Arrays.toString(passwords));
                showMessage("您注册的用户名为：" + userName + ",密码为：" + userPassword);
                break;
            } else
                showMessage("用户名存在，请重新输入");
        }

        while(true) {
            if(!isLogin){
                String newName = "";
                String newPassword = "";
                int i = 0;
                for(i = 0; i < 3; i ++) {
                    if(!newName.equals(names[index])
                            || !newPassword.equals(passwords[index])) {
                        System.out.println("请输入用户名和密码进行登录");
                        newName = scanner.next();
                        newPassword = scanner.next();
                    } else {
                        isLogin = true;
                        System.out.print("系统开始登录");
                        for(int j = 0; j < 10; j ++) {
                            Thread.sleep(100);
                            System.out.print("∷");
                        }
                        System.out.println("登录成功!账户Bo币:" + money[index]);
                        break;
                    }
                }
                if(i >= 3) {
                    System.out.println("超过3次输入错误，程序结束..");
                    isLogin = false;
                    break;
                }
            } else {
                System.out.println("请按照菜单选择对应的功能使用");
                System.out.println(menu);
                select = scanner.nextInt();
                switch (select) {
                    case 1:
                        isLogin = false;
                        break;
                    case 2:
                        System.out.println("您帐上的余额为:" + money[index]);
                        break;
                    case 3:
                        System.out.println("请输入原密码：");
                        String oldPassword = scanner.next();
                        //判断密码是否正确，只有3次机会
                        System.out.println("请输入新密码两次，每次输完后回车");
                        String newPassword1 = scanner.next();
                        String newPassword2 = scanner.next();
                        while(!newPassword1.equals(newPassword2) || !passwords[index].equals(oldPassword)) {
                            System.out.println("两次密码不一致,或原密码错误，请重新输入");
                            System.out.println("请输入原密码：");
                            oldPassword = scanner.next();
                            //判断密码是否正确，只有3次机会
                            System.out.println("请输入新密码两次，每次输完后回车");
                            newPassword1 = scanner.next();
                            newPassword2 = scanner.next();
                        }
                        passwords[index] = newPassword1;
                        isLogin = false;
                        break;
                    case 4:
                            System.out.println("请输入要充值的金额:");
                            int number = scanner.nextInt();
                            if (number >= 0) {
                                System.out.println("确定要充值" + number + "到Bo币吗?yes/no");
                                String yes = scanner.next();
                                if (yes.trim().equals("yes")) {
                                    money[index] += number;
                                    System.out.println("您此次充值" + number + "成功！账户Bo币为:" + money[index]);
                                } else {
                                    System.out.println("您取消了Bo币充值，账户Bo币为:" + money[index]);
                                }
                            } else {
                                showMessageLine("输入金额有误请重新输入！");
                            }
                       break;
                    case 5:
                        System.out.print("系统正在将为您选择点播内容，请稍候");
                        int random = (int) ((Math.random() * items.length) + 1);
                        itemName = items[random];
                        int itemMoney = (int) ((Math.random() * random) + 1);
                        if (money[index] < itemMoney) {
                            System.out.println("您点播的内容需要支付" + itemMoney + "您账户上的Bo币只有" + money[index] + ",请充值..");
                            break;
                        } else if (itemMoney == 0) {
                            System.out.println("恭喜你，你选的点播项属于免费项目..");
                        } else {
                            money[index] -= itemMoney;
                        }
                        System.out.println("您点播的内容是:" + itemName + ",消费为：" + itemMoney + ",账户Bo币剩余为：" + money[index]);
                        break;
                    case 6:
                        System.out.println("退出系统");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("输入的菜单项不存在，请重新选择");
                        break;
                }
            }
        }
    }
}
