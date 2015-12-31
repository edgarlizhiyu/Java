package com.game.v3;//

import com.game.v3.plant.ChilliPlant;
import com.game.v3.plant.PeaPlant;
import com.game.v3.plant.PlainPlant;

import java.util.Scanner;

//
//  游戏世界
//
//  @ Project : Untitled
//  @ File Name : GameWorld.java
//  @ Date : 2015/12/29
//  @ Author :
public class GameWorld {
    public static void showMessage(String messaeg)  {
        System.out.print(messaeg);
    }
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        showMessage("请注册用户，输入用户名和密码:\n");
        String name = scanner.next();//获取用户名和密码
        String password = scanner.next();
        //创建一个注册的玩家对象。
        Player player = new Player();
        player.setName(name);//设置文件的姓名
        player.setPassword(password);//设置玩家的密码
        //登录-暂不实现
        //创建僵尸和植物
        Zombies[] zombieses = new Zombies[10];
        Plant[] plants = new Plant[10];
        //随机创建僵尸和植物
        Zombies zombies = null;
        Plant plant = null;
        for(int i = 0; i < 10; i ++) {
            //产生一个0-9的随机数，作为数组的索引
            int random = (int)(Math.random() * 10);
            //构造一个僵尸对象，并分别设置僵尸类型、血量、攻击力和防御力
            zombies = new Zombies();
            zombies.setType("僵尸-" + i);
            zombies.setHp((i + 1) * 5);
            zombies.setAp((i + 1));
            zombies.setDef((i + 1) * 2);
            //构造植物对象，并分别设置植物类型、血量、太阳花、攻击力、防御力
            switch(random) {
                case 0:
                    plant = new ChilliPlant();
                    break;
                case 1:
                    plant = new PeaPlant();
                    break;
                default:
                    plant = new PlainPlant();
                    break;
            }
            //plant.setType("植物-" + i);
            plant.setHp((i + 1) * 10);
            plant.setAp((i + 1) * 2);
            plant.setDef((i + 1) * 2);
            plant.setSunNumber((i + 1) * 2);
            //将僵尸和植物放到对应的数组
            zombieses[random] = zombies;
            plants[random] = plant;
        }
        //接下来就开始游戏
        //1. 玩家选择植物并种植植物
        showMessage("序号     植物类型        血量      攻击力     防御力     太阳花\n");
        for(int i = 0; i < plants.length; i ++) {
            Plant tmpPlant = plants[i];
            if(tmpPlant != null){
                showMessage(i + "      " + tmpPlant.getType() + "       " +
                tmpPlant.getHp() + "        " + tmpPlant.getAp() + "        " +
                tmpPlant.getDef() + "       " + tmpPlant.getSunNumber() + "\n");
            }
        }
        showMessage("请选择需要种植的植物序号，可以选3次");
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        int index3 = scanner.nextInt();
        //将用户选择的植物存入到一个临时对战数组
        Plant[] gamePlant = {plants[index1],plants[index2],plants[index3]};
        Zombies attackZombies = null;
        while(attackZombies == null) {
            //2. 系统随机抽取僵尸进行攻击
            int zomIndex = (int) (Math.random() * 10);
            attackZombies = zombieses[zomIndex];
        }
        showMessage("当前抽取的僵尸是：" + attackZombies.toString() + "\n");
        //产生一个0-2的数，然后从临时对战数组里获取一个当前要和僵尸对战的植物
        int attackIndex = (int)(Math.random() * gamePlant.length);
        Plant attackPlant = gamePlant[attackIndex];
        showMessage(attackPlant.getType() + "和" + attackZombies.getType() + "酣战中");
        if(attackPlant instanceof IAttack) {
            while(attackPlant.getHp() > 0 && attackZombies.getHp() > 0) {
                //3. 植物进行防御和攻击.
                ((IAttack)attackPlant).attack(attackZombies);
                attackZombies.attack(attackPlant);
                try {
                    Thread.sleep(1000);
                    showMessage(".");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("该植物不具备攻击能力，所以游戏结束.....");
        }

        //4. 判断输赢
        if(attackPlant.getHp() > 0){
            showMessage("\n" + attackPlant.getType() + "获胜\n");
        } else {
            showMessage("\n" + attackZombies.getType() + "获胜\n");
        }
    }
}
