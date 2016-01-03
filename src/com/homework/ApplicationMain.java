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
        //选择账户
        int chooseAccount = -1;
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
        //原始密码
        String oldPassword;
        //新密码
        String newPassword;
        //确认新密码
        String newPasswordAgain;
        //初始化用户数组
        int number;
        number = 10;
        User[] user = new User[number];
        for (int i = 0; i < user.length; i++) {
            user[i] = new User();
        }
        //初始化账户数组
        Account[][] accounts = new Account[number][number];
        for(int j = 0 ; j < number ; j ++) {
            Account[] account = accounts[j];
            for (int i = 0; i < account.length; i++) {
                account[i] = new Account();
            }
        }
        //初始化点播节目数组
        Item[] items = new Item[number];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item();
        }

        //初始化点播日志数组
        int [][] records = new int[number][10];
        for(int i = 0; i < number; i ++){
            for(int j = 0 ; j < records[i].length;j ++){
                records[i][j] = -1;
            }
        }
        //添加点播对象
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
                        int time = 0;
                        if (index >= 0) {
                            do {
                                ui.showMainMenu();
                                if (input.hasNextByte()) {
                                    do {
                                        choose = input.nextInt();
                                        if ((1 <= choose && choose <= 8)) {
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
                                    //账户管理
                                    case 1:
                                        do{
                                        utils.showMessage("账户管理------------------------------------------->\n1, 添加账户  2, 删除账户  3，查询账户  4，修改密码  5，账户充值  6，返回到主菜单\n请选择：");
                                        choose = input.nextInt();
                                        switch (choose) {
                                            case 1:
                                                utils.showMessage("添加账户------------------------------------------->\n");
                                                utils.showMessage("\n请输入账户名:\n");
                                                name = input.next();
                                                utils.showMessage("\n请输入密码:\n");
                                                password = input.next();
                                                utils.showMessage("\n请输入金额:\n");
                                                str = input.next();
                                                int money = Integer.parseInt(str);
                                                utils.registerAccount(index, accounts, name, password, money);
                                                utils.showMessage("继续请输入0 否则返回上一级菜单\n");
                                                choose = input.nextInt();
                                                if (choose == 0) {
                                                    isRight = true;
                                                    toMainMenu = true;
                                                } else {
                                                    isRight = false;
                                                }

                                                break;
                                            //删除账户
                                            case 2:
                                                utils.showMessage("删除账户------------------------------------------->\n");
                                                utils.showMessage("序号\t\t账户名\t\t余额\n");
                                                for(int i = 0;i < accounts[index].length ; i ++){
                                                    if(accounts[index][i].getName() == null){
                                                        break;
                                                    }
                                                    utils.showMessage((i+1)+"\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                                }
                                                utils.showMessage("请选择需要删除的账户\n");
                                                choose = input.nextInt();
                                                utils.showMessage("请输入原始密码：\n");
                                                oldPassword = input.next();
                                                if(accounts[index][choose-1].getPassword().equals(oldPassword)) {
                                                    accounts[index][choose-1].setName(null);
                                                    accounts[index][choose-1].setPassword(null);
                                                    accounts[index][choose-1].setMoney(0);
                                                    utils.showMessage("删除成功！\n");
                                                }else{
                                                    utils.showMessage("密码错误\n");
                                                }
                                                utils.showMessage("继续请输入0 否则返回上一级菜单\n");
                                                choose = input.nextInt();
                                                if (choose == 0) {
                                                    isRight = true;
                                                    toMainMenu = true;
                                                } else {
                                                    isRight = false;
                                                }
                                                break;
                                            //查询账户
                                            case 3:
                                                utils.showMessage("查询账户------------------------------------------->\n");
                                                utils.showMessage("序号\t\t账户名\t\t余额\n");
                                                for(int i = 0;i < accounts[index].length ; i ++){
                                                    if(accounts[index][i].getName() == null){
                                                        break;
                                                    }
                                                    utils.showMessage((i+1)+"\t\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                                }
                                                utils.showMessage("继续修改请输入0 否则返回上一级菜单\n");
                                                choose = input.nextInt();
                                                if (choose == 0) {
                                                    isRight = true;
                                                    toMainMenu = true;
                                                } else {
                                                    isRight = false;
                                                }
                                                break;
                                            //修改密码
                                            case 4:
                                                utils.showMessage("修改账户密码------------------------------------------->\n");
                                                utils.showMessage("序号\t\t账户名\t\t余额\n");
                                                for(int i = 0;i < accounts[index].length ; i ++){
                                                    if(accounts[index][i].getName() == null){
                                                        break;
                                                    }
                                                    utils.showMessage((i+1)+"\t\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                                }
                                                utils.showMessage("请选择需要修改的账户");
                                                choose = input.nextInt();
                                                utils.showMessage("请输入原始密码：\n");
                                                oldPassword = input.next();
                                                utils.showMessage("请输入新密码：\n");
                                                newPassword = input.next();
                                                utils.showMessage("请再输入一次新密码：\n");
                                                newPasswordAgain = input.next();
                                                if (accounts[index][choose-1].getPassword().equals(oldPassword)) {
                                                    if (newPassword.equals(newPasswordAgain)) {
                                                        accounts[index][choose-1].setPassword(newPassword);
                                                        utils.showMessage("修改成功，之后请用新密码登陆\n");
                                                    } else {
                                                        utils.showMessage("两次输入密码不一致！\n");
                                                    }
                                                } else {
                                                    utils.showMessage("密码错误\n");
                                                }
                                                utils.showMessage("返回上一级菜单输入 0\n");
                                                choose = input.nextInt();
                                                if (choose == 0) {
                                                    isRight = true;
                                                } else {
                                                    isRight = false;
                                                    toMainMenu = true;
                                                }
                                                break;
                                            //账户充值
                                            case 5:
                                                do{
                                                    utils.showMessage("充值------------------------------------------->\n");
                                                    utils.showMessage("序号\t\t账户名\t\t余额\n");
                                                    for(int i = 0;i < accounts[index].length ; i ++){
                                                        if(accounts[index][i].getName() == null){
                                                            break;
                                                        }
                                                        utils.showMessage((i+1)+"\t\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                                    }
                                                    utils.showMessage("请选择充值账号\n");
                                                    chooseAccount = input.nextInt();
                                                    utils.showMessage("请输入充值金额\n");
                                                    str = input.next();
                                                    isRight = utils.isDigit(str);
                                                    if(utils.isDigit(str)) {
                                                        money = Integer.parseInt(str);
                                                        if (0 <= money) {
                                                            utils.showMessage("你充值的金额：" + money + "\n");
                                                            accounts[index][chooseAccount-1].setMoney(accounts[index][chooseAccount-1].getMoney() + money);
                                                            utils.showMessage("当前余额为：" + accounts[index][chooseAccount-1].getMoney() + "\n");
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
                                            case 6:
                                                isRight = false;
                                                toMainMenu =true;
                                                break;
                                        }
                                        }while (isRight);
                                        break;
                                    //查询余额选项
                                    case 2:
                                        do {
                                            utils.showMessage("余额查询------------------------------------------->\n");
                                            utils.showMessage("查询账户------------------------------------------->\n");
                                            utils.showMessage("序号\t\t账户名\t\t余额\n");
                                            for(int i = 0;i < accounts[index].length ; i ++){
                                                if(accounts[index][i].getName() == null){
                                                    break;
                                                }
                                                utils.showMessage((i+1)+"\t\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                            }
                                            utils.showMessage("\n继续查询请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                isRight = true;
                                                toMainMenu = true;
                                            } else {
                                                isRight = false;
                                                toMainMenu = false;
                                            }
                                        } while (!isRight);
                                        break;
                                    //修改密码选项
                                    case 3:
                                        do {
                                            utils.showMessage("修改密码------------------------------------------->\n请输入原始密码：\n");
                                            oldPassword = input.next();
                                            utils.showMessage("请输入新密码：\n");
                                            newPassword = input.next();
                                            utils.showMessage("请再输入一次新密码：\n");
                                            newPasswordAgain = input.next();
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
                                    //点播选项
                                    case 4:
                                        do {
                                            utils.showMessage("点播节目------------------------------------------->\n序号\t价格\t影片名\t\t作 者\t\t上映日期\t\t内容介绍 \n");
                                            for(int i = 0;i < items.length; i ++){
                                                if(items[i].getName() == null){
                                                    break;
                                                }
                                                    utils.showMessage((i+1)+"\t\t"+items[i].getPrice()+"\t\t"+items[i].getName()+"\t\t"+items[i].getAuthor()+"\t\t"+items[i].getDateOfPublication()+"\t\t"+items[i].getProspectus()+"\n");
                                            }
                                            utils.showMessage("请选择观看的影片序号\n");
                                            choose = input.nextInt();
                                            utils.showMessage("序号\t\t账户名\t\t余额\n");
                                            for(int i = 0;i < accounts[index].length ; i ++){
                                                if(accounts[index][i].getName() == null){
                                                    break;
                                                }
                                                utils.showMessage((i+1)+"\t\t\t"+accounts[index][i].getName()+"\t\t"+accounts[index][i].getMoney()+"\n");
                                            }
                                            utils.showMessage("请选择支付账号\n");
                                            chooseAccount = input.nextInt();
                                            accounts[index][chooseAccount-1].setMoney(accounts[index][chooseAccount-1].getMoney() - items[choose-1].getPrice());
                                            if (accounts[index][chooseAccount-1].getMoney() >= 0) {
                                                utils.showMessage("你点播的是" + items[choose-1].getName() + "消耗" + items[choose-1].getPrice() + "New币" + "请慢慢欣赏！\n");
                                                records[index][time] = choose-1;
                                                time++;
                                            } else {
                                                utils.showMessage("余额不足请及时充值！\n");
                                                //优化余额变成负数
                                                accounts[index][chooseAccount-1].setMoney(accounts[index][chooseAccount-1].getMoney() + items[choose-1].getPrice());
                                            }
                                            utils.showMessage("继续点播请输入0 否则返回上一级菜单\n");
                                            choose = input.nextInt();
                                            if (choose == 0) {
                                                isRight = true;
                                            } else {
                                                isRight = false;
                                                toMainMenu = true;
                                            }
                                        } while (isRight);
                                        break;
                                    //点播日志选项
                                    case 5:
                                        utils.showMessage("点播日志------------------------------------------->\n序号\t价格\t影片名\t\t作 者\t\t上映日期\t\t内容介绍 \n");
                                        int [] record = records[index];
                                        for(int i = 0;i < record.length ; i ++){
                                            if(records[index][i] == -1){
                                                break;
                                            }
                                            utils.showMessage((i+1)+"\t\t"+items[records[index][i]].getPrice()+"\t\t"+items[records[index][i]].getName()+"\t\t"+items[records[index][i]].getAuthor()+"\t\t"+items[records[index][i]].getDateOfPublication()+"\t\t"+items[records[index][i]].getProspectus()+"\n");
                                        }
                                        utils.showMessage("输入0返回主菜单\n");
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
