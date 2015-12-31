package com.game.v3.plant;

import com.game.v3.IAttack;
import com.game.v3.Plant;
import com.game.v3.Spirit;
import com.game.v3.Zombies;

/**
 * Created by zn on 2015/12/29.
 */
public class ChilliPlant extends Plant implements IAttack {

    public ChilliPlant() {
        this.setType("红辣椒植物");
    }
    public void attack(Spirit spirit) {
        Zombies zombies = (Zombies)spirit;
        System.out.println("个你一个辣辣的吻");
        int off = (this.getAp() * 10) - zombies.getDef();
        if(off > 0){
            zombies.setHp(zombies.getHp() - off);
        }
        System.out.println("一个辣辣的吻结束");
    }
}
