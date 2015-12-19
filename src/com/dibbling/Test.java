package com.dibbling;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/15.
 * 点播程序
 * 实现功能如下：
 * 1，多用户注册 只要不退出程序可保存多用户的余额
 * 2，实现播放日志功能
 * 3，实现主菜单 2级菜单的切换
 * 4，多出优化用户体验！
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        String str = "";//控制主菜单循环跳出开关
        String str1 = "";//控制次要菜单循环跳出开关
        int [] array = new int[100];//初始化点播日志数组
        byte frequency = 0;//初始化 点播次数
        int number1 = 0;//提高用户体验初始化 见162 L
        byte time = 0;
        String name = "";//初始化登录名
        String password = "";//初始化登录密码
        Scanner input = new Scanner(System.in);
        MainMenu all = new MainMenu();//新建主菜单对象
        Menu firstMenu = new Menu();//新建次要菜单对象
        Judgment firstJudgment = new Judgment();//新建第一个判断对象
        Judgment secondJudgment = new Judgment();//新建第二个判断对象
        In firstIn = new In();//新建第一个注册对象
        Things movies = new Things();
        int money =0;
        firstIn.time = 0;
        //程序的主界面
        do {
            all.show();
            //判定用户是否输入正确选项
            firstJudgment.show();
            //switch  来展开选择后的界面
            switch (firstJudgment.number) {
                //（选择登陆输入账户密码）
                // ---------------------登陆成功后显示界面

                case 1:
                    System.out.print("请输入用户名：");
                    name = input.next();
                    System.out.println();
                    System.out.print("请输入密码：");
                    password = input.next();
                    //登陆动画 优化用户体验
                    System.out.print("系统登录中");
                    for (int i = 0 ; i <= 1;i++){
                        System.out.print(".");
                        Thread.sleep(500);
                    }
                    System.out.println();//美化  换行

                    for (int a = 0; a <= firstIn.time; a++) {
                        if (name.equals(firstIn.name[a]) && password.equals(firstIn.password[a])) {
                            System.out.println("登陆成功...");
                            money = firstIn.money[a];
                            do {
                                firstMenu.show();
                                secondJudgment.j = 7;
                                secondJudgment.show();
                                //登陆后的各个选项
                                switch (secondJudgment.number) {
                                    //----------------------1，查询余额
                                    case 1:

                                        System.out.println("当前余额为：" + money);
                                        break;
                                    //----------------------2，修改密码
                                    //--------------------------------修改成功会需重新登陆
                                    //--------------------------------输入的原始密码不正确提示   输入的新密码两次不同 提示
                                    case 2:
                                        System.out.println("请输入当前密码：");
                                        password = input.next();
                                        //验证是否输入的密码正确
                                        if (firstIn.password[a].equals(password)) {
                                            //第一次输入新密码
                                            System.out.println("请输入新密码：");
                                            String passwordNew1 = input.next();
                                            //第二次输入新密码
                                            System.out.println("请再次输入新密码：");
                                            String passwordNew2 = input.next();
                                            //验证2次输入的密码是否一致
                                            if (passwordNew1.equals(passwordNew2)) {
                                                firstIn.password[a] = passwordNew1;
                                                System.out.println("修改成功，请重新登录");
                                            } else {
                                                System.out.println("两次输入密码不一致！");
                                            }
                                        } else {
                                            System.out.println("密码错误");
                                        }
                                        break;
                                    //----------------------3，充值
                                    //-----------------------------如果输入的金额不正确 提示
                                    case 3:
                                        System.out.println("请输入充值金额：");
                                        if (input.hasNextInt()) {
                                            int number = input.nextInt();
                                            if (0 <= number) {
                                                System.out.println("你充值的金额：" + number);
                                                money += number;
                                                //匹配到每个对象里面去跟随对象走
                                                firstIn.money[a] = money;
                                                System.out.println("当前余额为：" + money);
                                            } else {
                                                System.out.println("请输入正确的金额！");
                                            }
                                        } else {
                                            System.out.println("请输入正确的金额！");
                                        }

                                        break;
                                    //----------------------4，点播
                                    //-----------------------------随机点播 数组里面的值
                                    case 4:
                                        do {
                                            movies.rand();
                                            money -= movies.number;
                                            //匹配到每个对象里面去跟随对象走
                                            firstIn.money[a] = money;
                                            if (money > 0) {
                                                movies.show();
                                                //点播日志提取数据
                                                time++;
                                                array[frequency] = movies.number - 1;
                                                frequency++;
                                            } else {
                                                System.out.println("余额不足请及时充值！");
                                                //优化余额变成负数
                                                money += movies.number;
                                                //匹配到每个对象里面去跟随对象走
                                                firstIn.money[a] = money;
                                            }
                                            System.out.println("继续点播请输入<yes>");
                                            str = input.next();
                                        } while (str.equals("yes"));

                                        break;
                                    //----------------------5，查看点播日志
                                    case 5:
                                /*
                                * 创建数组 接收随机值
                                * 根据数组下标 再输出 Things 类里面的 things []
                                * */
                                        for (int i = 0; i < time; i++) {
                                            System.out.println("第" + (i + 1) + "次点播节目为：\t" + movies.things[array[i]]);
                                        }
                                        break;
                                    //----------------------6，注销 返回到主界面
                                    case 6:

                                        str = "yes";//返回主菜单
                                        str1 = "1";//不返回上一级菜单
                                        break;
                                    //----------------------7，退出
                                    case 7:

                                        str = "no";//不返回主菜单
                                        str1 = "1";//不返回上一级菜单
                                        break;

                                }
                                if (1 <= secondJudgment.number && secondJudgment.number <= 5) {
                                    System.out.println("返回上一级请输入数字<0>否则退出程序");
                                    str1 = input.next();
                                } else {
                                    //优化 提高用户体验
                                    System.out.print("");
                                }
                            } while (str1.equals("0"));
                            break;
                        }else{
                            //优化用户体验 控制登陆失败后的 输出
                            if(a == (firstIn.time-1)) {
                                System.out.println("登陆失败");
                            }else {
                                System.out.print("");
                            }
                        }

                    }
                    break;
                //（选择注册输入账户密码 并送10元）
                case 2:
                    firstIn.show();
                    System.out.println("返回主菜单请输入<yes>否则退出程序");
                    str = input.next();
                    break;
                //（选择退出则退出程序）
                case 3:
                    System.out.println("谢谢使用程序退出！");
                    str = "no";
                    break;
            }
            //优化 提高用户体验
            System.out.print("");
        } while (str.equals("yes"));
        if (firstJudgment.number == 3) {
            //优化 提高用户体验
            System.out.print("");
        } else {
            System.out.println("谢谢使用程序退出！");
        }

    }
}
