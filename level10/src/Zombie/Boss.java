package Zombie;

import java.util.*;

//Boss 클래스는 Zombie 클래스를 상속받는다.
//Boss 클래스는 보호막 shield 멤버변수를 가진다.
//공격 메소드 void attack( Unit enemy ) 
//일반공격 : 1~공격력(max) 사이의 랜덤 값을 공격력으로 사용하여 enemy의 체력 감소시킴 (출력 예 : “보스가 15 의 공격력으로 일반 공격 : 현재 Hero의 hp는 25”)
//필살기 : 25%의 확률로 1~max 사이의 공격력의 2배 만큼으로 상대를 공격하는 기능 (출력 예 : “보스가 30 의 공격력으로 필살기 공격 : 현재 Hero의 hp는 25”)
//Boss 클래스는 생성자를 가짐(현재위치, 체력,공격력, 보호막)

public class Boss extends Zombie {

	Random r = new Random();

	private int shield;

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public Boss(String name, int pos, int hp, int power, int shield) {
		super("보스", pos, hp, power);
		this.shield = shield;
	}

	@Override
	public String toString() {
		return super.toString() + "보스의 Shield : " + shield;
	}

	public void attack(Unit unit) {
		int rand = r.nextInt(4);
		if (rand != 0) {
			super.attack(unit);
		} else {
			unit.setHp(unit.getHp() - this.getDamage());
			if (unit.getHp() < 0) {
				unit.setHp(0);
			}
			this.setDamage(this.getDamage()*2);
			System.out.printf("%s 가 %d 필살 공격 %s %s\n",this.getName(), this.getDamage(), unit, this);
			this.setHp(this.getHp() + this.getDamage() / 2);
			if (this.getHp() > this.getMAX_HP()) {
				this.setHp(getMAX_HP());
			}
			System.out.print(" " + this.getName() + "가 체력 회복" + this.getHp());

		}
	}
}