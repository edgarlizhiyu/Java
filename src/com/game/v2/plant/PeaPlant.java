package com.game.v2.plant;

import com.game.v2.Plant;
import com.game.v2.Zombies;

/**
 * 豌豆植物
 * Created by zn on 2015/12/29.
 */
public class PeaPlant extends Plant{
    public PeaPlant() {
        this.setType("豌豆植物");
    }
    @Override
    public void attack(Zombies zombies) {
        System.out.println("连续发射3颗豌豆");
        int off = (this.getAp() * 3) - zombies.getDef();
        if(off > 0){
            zombies.setHp(zombies.getHp() - off);
        }
        System.out.println("攻击完毕");
    }
}
