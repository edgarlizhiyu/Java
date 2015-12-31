package com.game.v2;//

//
//  僵尸
//
//  @ Project : c13
//  @ File Name : Zombies.java
//  @ Date : 2015/12/29
//  @ Author : zn
//
public class Zombies {
	private int hp;
	private int ap;
	private int def;
	private String type;

	/**
	 *
	 */
	public void attack(Plant plant) {
		int off = ap - plant.getDef();
		if(off > 0){
			plant.setHp(plant.getHp() - off);
		}
	}
	
	public void defense() {
	
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String toString() {
		return "hp:" + hp + ",ap:" + ap + ",def:" + def + ",type:" + type;
	}
}
