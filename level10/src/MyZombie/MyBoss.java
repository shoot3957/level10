package MyZombie;

import java.util.Random;


public class MyBoss extends MyZombie {
	Random rd = new Random();
	private int shield;
	
	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public MyBoss(String name, int pos, int hp, int power, int shield) {
		super(name, pos, hp, power);
		this.shield=shield;
		// TODO Auto-generated constructor stub
		
	}
	public String toString() {
		return super.toString() + "보스의 Shield : " + shield;
	}
	public void attack(MyUnit unit) {
		int rand = rd.nextInt(4);
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
