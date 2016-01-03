package com.homework;

import com.homework.Item;
import com.homework.Ui;
import com.homework.User;
import com.homework.Utils;
import com.homework.movise.Car;
import com.homework.movise.Hero;

import java.util.Scanner;

/**
 * Created by zn on 2015/12/31.
 * 点播系统主入口
 */
public class ApplicationMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Utils utils = new Utils();
        Ui ui = new Ui();
        //用户索引
        int index;
        //用户选择
        int choose = -1;
        //判断
        boolean isRight = false;
        //返回主菜单
        boolean toMainMenu = false;
        //返回菜单
        boolean toMenu = false;
        //接收用户输入信息
        String str;
        //接收用户名
        String name;
        //接收密码
        String password;
        //初始化用户数组
        User[] user = new User[10];
        for (int i = 0; i < user.length; i++) {
            user[i] = new User();
        }
        //初始化点播节目数组
        Item[] items = new Item[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item();
        }
        Item car = new Car();
        Item hero = new Hero();
        utils.addItem(items,car);
        utils.addItem(items,hero);

        do {
            ui.showMenu();
            do {
                if (input.hasNextInt()) {
                    choose = input.nextInt();
                    if ((1 <= choose && choose <= 3)) {
                        isRight = true;
                    } else {
                        utils.showMessage("输入错误" + "\n请重新选择正确选项：\n");
                        isRight = false;
                    }
                } else {
                    utils.showMessage("输入错误" + "\n请重新选择正确选项：\n");
                    isRight = false;
                }
            } while (!isRight);
            do {

                switch (choose) {
                    case 1:
                        utils.showMessage("请输入用户名:\n");
                        name = input.next();
                        utils.showMessage("请输入密码:\n");
                        password = input.next();
                        index = utils.login(user, name, password);
                        if (index >= 0) {
                            do {
                                ui.showMainMenu();
                                if (input.hasNextByte()) {
                                    do {
                                        choose = input.nextInt();
                                        if ((1 <= choose && choose <= 7)) {
                                            isRight = true;
                                        } else {
                                            utils.showMessage("选择错误，并没有此选项！" + "\n请重新选择：\n");
                                            isRight = false;
                                        }
                                    } while (!isRight);
                                } else {
                                    utils.showMessage("操作错误程序退出！\n");
                                }
                                switch (choose) {
                                    //查询余额选项
                                    case 1:
                                        do {
                                            utils.showMessage("当前余额：" + user[index].getMoney());
                                            utils.showMessage("\n继续查询请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                isRight = true;
                                            } else {
                                                isRight = false;
                                            }
                                        } while (!isRight);

                                        if (choose == 0) {
                                            toMainMenu = true;
                                        } else {
                                            toMainMenu = false;
                                        }
                                        break;
                                    //修改密码选项
                                    case 2:
                                        do {
                                            utils.showMessage("请输入原始密码：\n");
                                            String oldPassword = input.next();
                                            utils.showMessage("请输入新密码：\n");
                                            String newPassword = input.next();
                                            utils.showMessage("请再输入一次新密码：\n");
                                            String newPasswordAgain = input.next();
                                            if (user[index].getPassword().equals(oldPassword)) {
                                                if (newPassword.equals(newPasswordAgain)) {
                                                    user[index].setPassword(newPassword);
                                                    utils.showMessage("修改成功，之后请用新密码登陆\n");
                                                } else {
                                                    utils.showMessage("两次输入密码不一致！\n");
                                                }
                                            } else {
                                                utils.showMessage("密码错误\n");
                                            }
                                            utils.showMessage("继续修改请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                isRight = true;
                                                toMainMenu = true;
                                            } else {
                                                isRight = false;
                                            }
                                        } while (!isRight);
                                        break;
                                    //充值选项
                                    case 3:

                                        do{
                                            utils.showMessage("请输入需要充值金额：\n");
                                            str = input.next();
                                            isRight = utils.isDigit(str);
                                            if(utils.isDigit(str)) {
                                                int money = Integer.parseInt(str);
                                                if (0 <= money) {
                                                    utils.showMessage("你充值的金额：" + money + "\n");
                                                    user[index].setMoney(user[index].getMoney() + money);
                                                    utils.showMessage("当前余额为：" + user[index].getMoney() + "\n");
                                                } else {
                                                    utils.showMessage("请输入正确的金额！\n");
                                                }
                                                utils.showMessage("继续充值请输入0 否则返回上一级菜单\n");
                                                choose = input.nextInt();
                                                if (choose == 0) {
                                                    toMainMenu = true;
                                                } else {
                                                    toMainMenu = false;
                                                }
                                            }else{
                                                utils.showMessage("输入错误请输入正确的金额！\n");
                                            }
                                        }while (!isRight);
                                        while (!utils.isDigit(str)) {
                                            utils.showMessage("输入有误！\n继续充值请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                toMainMenu = true;
                                            } else {
                                                toMainMenu = false;
                                            }
                                        }
                                        break;
                                    //点播选项
                                    case 4:
                                        do {
                                            utils.showMessage("序号\t价格\t影片名\t\t作 者\t\t上映日期\t\t内容介绍 \n");
                                            for(int i = 0;i < items.length; i ++){
                                                if(items[i].getName() == null){
                                                    break;
                                                }
                                                    utils.showMessage((i+1)+"\t\t"+items[i].getPrice()+"\t\t"+items[i].getName()+"\t\t"+items[i].getAuthor()+"\t\t"+items[i].getDateOfPublication()+"\t\t"+items[i].getProspectus()+"\n");
                                            }
                                            utils.showMessage("请选择观看的影片序号\n");
                                            choose = input.nextInt();
                                            user[index].setMoney(user[index].getMoney() - items[choose-1].getPrice());
                                            if (user[index].getMoney() >= 0) {
                                                utils.showMessage("你点播的是" + items[choose-1].getName() + "消耗" + items[choose-1].getPrice() + "New币" + "请慢慢欣赏！\n");
                                            } else {
                                                utils.showMessage("余额不足请及时充值！\n");
                                                //优化余额变成负数
                                                user[index].setMoney(user[index].getMoney() + items[choose-1].getPrice());
                                            }
                                            utils.showMessage("继续点播请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                isRight = true;
                                                toMainMenu = true;
                                            } else {
                                                isRight = false;
                                            }
                                        } while (!isRight);
                                        break;
                                    //点播日志选项
                                    case 5:
                                        utils.showMessage("系统升级中\n输入0返回主菜单\n");
                                        choose = input.nextInt();
                                        if (choose == 0) {
                                            toMainMenu = true;
                                        } else {
                                            toMainMenu = false;
                                        }
                                        break;
                                    //注销选项
                                    case 6:
                                        toMainMenu = false;
                                        toMenu = true;
                                        isRight = false;
                                        break;
                                    //推出程序选项
                                    case 7:
                                        toMainMenu = false;
                                        toMenu = false;
                                        utils.showMessage("程序结束谢谢使用！\n");
                                        break;
                                }
                            } while (toMainMenu);
                        }

                        break;
                    //注册用户选项
                    case 2:
                        ui.showAddMenu();
                        utils.showMessage("\n请输入用户名:\n");
                        name = input.next();
                        utils.showMessage("\n请输入密码:\n");
                        password = input.next();
                        utils.showMessage("\n请输入性别:\n");
                        String gender = input.next();
                        utils.showMessage("\n请输入联系地址:\n");
                        String address = input.next();
                        utils.register(user, name, password,gender,address);
                        toMenu = true;
                        toMainMenu = false;
                        break;
                    //推出选项
                    case 3:
                        toMainMenu = false;
                        toMenu = false;
                        utils.showMessage("程序结束谢谢使用！\n");
                        break;
                }
            } while (toMainMenu);
        } while (toMenu);

    }
}
