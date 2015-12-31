package com.game.v1;
//植物类
//  @ Project : Untitled
//  @ File Name : 植物对象
//  @ Date : 2015/12/29
//  @ Author : 
//
//


public class Plant {
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

	//太阳点
	private int sunNumber;

	public int getSunNumber() {
		return sunNumber;
	}

	public void setSunNumber(int sunNumber) {
		this.sunNumber = sunNumber;
	}

	//植物种类
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 攻击行为
	 */
	public void attack(Zombies zombies) {
		int off = ap - zombies.getDef();
		if(off > 0){
			zombies.setHp(zombies.getHp()-off);
		}
	}

	/**
	 * 防御行为
	 */
	public void defense() {
	
	}
}
