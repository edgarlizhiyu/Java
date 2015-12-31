package com.game.v3;
//
//  植物对象
//  @ Project : c13
//  @ File Name : Plant.java
//  @ Date : 2015/12/29
//  @ Author : zn
//
//


public abstract class Plant extends Spirit{
	//血量
	private int hp;
	//攻击力
	private int ap;
	//防御力
	private int def;
	//太阳点
	private int sunNumber;
	//植物类型，现在的结构里，该属性可以去掉
	private String type;


	/**
	 * 防御
	 */
	public void defense() {

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

	public int getSunNumber() {
		return sunNumber;
	}

	public void setSunNumber(int sunNumber) {
		this.sunNumber = sunNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
