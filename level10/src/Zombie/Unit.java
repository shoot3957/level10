package Zombie;

import java.util.*;

// 유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
// 맵은 ~10까지 존재하며 한칸씩 이동 가능하다
// 유닛들은 전부 attack 메서드를 구현한다 

abstract public class Unit {
	private String name;
	private int pos; // 현재위치
	private int hp; // 현재 hp
	private final int MAX_HP;
	private int power; // 랜덤 공격 1부터 max 까지의 범위
	private Random rd; // 각각 하위 유닛들이 이 랜덤 클래스 사용해서 공격 범위 지정
	private int damage;
	
	public int getMAX_HP() {
		return MAX_HP;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Random getRd() {
		return rd;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public String getName() {
		return name;
	}

	public Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		this.MAX_HP = hp;
		this.power = power;
		rd = new Random();
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}
	
	@Override
	public String toString() {
		return name + "의 체력 " + hp + " ";
	}

	public void attack(Unit unit) {
		unit.setHp(unit.getHp()-damage);
		if(unit.getHp() < 0) {
			unit.setHp(0);
		}
		System.out.printf("%s 가 %d 대미지 공격 %s %s \n",name, damage, unit,this);
	}
}