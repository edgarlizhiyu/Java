package com.game.v1;
//
//  僵尸类
//
//  @ Project : Untitled
//  @ File Name : Zombies.java
//  @ Date : 2015/12/29
//  @ Author : 
//
//


public class Zombies {
	//血量
	private int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	//攻击力
	private int ap;

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	//防御力
	private int def;

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	//僵尸种类
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String toString(){
		return "僵尸类型-"+getType()+",血量："+getHp()+"攻击力："+getAp()+"防御力："+getDef();
	}

	/**
	 * 攻击行为
	 */
	public void attack(Plant plant) {
		int off = ap - plant.getDef();
		if(off > 0){
			plant.setHp(plant.getHp()-off);
		}
	}
	/**
	 * 防御行为
	 */
	public void defense() {
	
	}
}
