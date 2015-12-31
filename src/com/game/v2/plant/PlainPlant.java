package com.game.v2.plant;

import com.game.v2.Plant;
import com.game.v2.Zombies;

/**
 * 普通植物
 * Created by zn on 2015/12/29.
 */
public class PlainPlant extends Plant{
    public PlainPlant() {
        this.setType("普通植物");
    }
    @Override
    public void attack(Zombies zombies) {
        int off = this.getAp() - zombies.getDef();
        if(off > 0){
            zombies.setHp(zombies.getHp() - off);
        }
    }
}
