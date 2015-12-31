package com.game.v2.plant;

import com.game.v2.Plant;
import com.game.v2.Zombies;

/**
 * Created by zn on 2015/12/29.
 */
public class ChilliPlant extends Plant{

    public ChilliPlant() {
        this.setType("红辣椒植物");
    }
    @Override
    public void attack(Zombies zombies) {
        System.out.println("个你一个辣辣的吻");
        int off = (this.getAp() * 10) - zombies.getDef();
        if(off > 0){
            zombies.setHp(zombies.getHp() - off);
        }
        System.out.println("一个辣辣的吻结束");
    }
}
