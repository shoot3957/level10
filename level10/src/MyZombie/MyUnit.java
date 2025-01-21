package MyZombie;

import java.util.Random;

abstract public class MyUnit {
	private String name;
	private int pos; // 현재위치
	private int hp; // 현재 hp
	private final int MAX_HP;
	private int power; // 랜덤 공격 1부터 max 까지의 범위
	private Random rd; // 각각 하위 유닛들이 이 랜덤 클래스 사용해서 공격 범위 지정
	private int damage;

	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getPos() {
		return pos;
	}
	void setPos(int pos) {
		this.pos = pos;
	}
	int getHp() {
		return hp;
	}
	void setHp(int hp) {
		this.hp = hp;
	}
	int getMAX_HP() {
		return hp;
	}
	int getPower() {
		return power;
	}
	void setPower(int power) {
		this.power = power;
	}
	Random getRd() {
		return rd;
	}
	void setRd(Random rd) {
		this.rd = rd;
	}
	int getDamage() {
		return damage;
	}
	void setDamage(int damage) {
		this.damage = damage;
	}

	public MyUnit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp= hp;
		this.MAX_HP = hp;
		this.power = power;
	}
	
	public void attack(MyUnit myUnit) {
		myUnit.setHp(myUnit.getHp()-damage);
		if(myUnit.getHp()<0) {
			myUnit.setHp(0);
		}
		System.out.printf("%s 가 %d 대미지 공격 %s %s \n",name, damage, myUnit,this);
	}
	
}
