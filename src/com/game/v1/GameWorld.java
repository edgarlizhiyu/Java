package com.game.v1;

import java.util.Scanner;

/**
 * Created by pc on 2015/12/29.
 */
public class GameWorld {
    public static void showMessage(String message){
        System.out.print(message);
    }
    public static void main(String [] args){
        //用户注册
        Scanner scanner = new Scanner(System.in);
        showMessage("请注册用户，输入用户名和密码：\n");
        String name = scanner.next();
        String password = scanner.next();
        Player player = new Player();
        player.setName(name);
        player.setPassword(password);
        Zombies [] zombies = new Zombies[10];
        Plant[] plants = new Plant[10];
        //随机创建植物，僵尸
        Zombies zomby = null;
        Plant plant = null;
        for(int i = 0; i < zombies.length; i ++){
            //产生随机数
            int random = (int)(Math.random()*10);
            //新建僵尸对象
            zomby = new Zombies();
            //僵尸类型
            zomby.setType("僵尸-"+i);
            //僵尸血量
            zomby.setHp((i+1)*5);
            //僵尸攻击力
            zomby.setAp((i+1)*2);
            //僵尸防御力
            zomby.setDef((i+1));
            //新建植物对象
            plant = new Plant();
            //植物类型
            plant.setType("植物-"+i);
            //植物血量
            plant.setHp((i+1)*5);
            //植物攻击力
            plant.setAp((i+1)*2);
            //植物防御力
            plant.setDef((i+1));
            //太阳点
            plant.setSunNumber((i+1)*2);
            zombies[random] = zomby;
            plants[random] = plant;
        }
        //开始游戏
        //1.玩家选择植物并种植
        showMessage("序号     植物类型    血量    攻击力    防御力    太阳花\n");
        for(int i = 0;i < plants.length; i ++){
            Plant temPlant = plants[i];
            if(temPlant !=null){
                showMessage(i+"    "+temPlant.getType()+"    "+temPlant.getHp()+"    "+temPlant.getAp()+"    "+temPlant.getDef()+"    "+temPlant.getSunNumber()+"\n");
            }
        }
        showMessage("请选择3个植物：\n");
        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        int index3 = scanner.nextInt();
        Plant[] gamePlant = {plants[index1],plants[index2],plants[index3]};
        //2.系统随机抽取僵尸进攻
        Zombies attactZombies = null;
        while(attactZombies == null) {
            int zomindex = (int) (Math.random() * 10);
            attactZombies = zombies[zomindex];
        }
        showMessage("当前对战僵尸："+attactZombies.toString()+"\n");
        //3.植物进行防御和攻击
        int attactIndex = (int)(Math.random()*gamePlant.length);
        Plant attactPlants = gamePlant[attactIndex];
        showMessage(attactPlants.getType()+"和"+attactZombies+"厮杀中\n");
        while(attactPlants.getHp() >0 && attactZombies.getHp() >0){
            attactPlants.attack(attactZombies);
            attactZombies.attack(attactPlants);
            try {
                Thread.sleep(1000);
                showMessage(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //4.判断输赢
        if(attactPlants.getHp()>0){
            showMessage("\n"+attactPlants.getType()+"获胜\n");
        }else{
            showMessage("\n"+attactZombies.getType()+"获胜\n");
        }
    }
}
