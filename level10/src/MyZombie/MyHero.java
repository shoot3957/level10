package MyZombie;

import Zombie.Boss;

public class MyHero extends MyUnit{
	private int count = 0;

	int getCount() {
		return count;
	}
	
	public MyHero(String name, int pos, int hp, int power, int count) {
		super(name, pos, hp, power);
		this.count= count;
	}
	public void potion() {
		count -= 1;
		System.out.println("체력 100 회복");
		this.setHp(this.getHp()+100);
	}
	
	public void bossAttack(MyBoss boss) {
		if(boss.getShield() > 0) {
			boss.setShield(boss.getShield()-this.getDamage());
			if(boss.getShield() <= 0) {
				boss.setShield(0);
			}
		}else {
			boss.setHp(boss.getHp()-this.getDamage());
		}
		System.out.printf("%s 가 %d 대미지 공격 \n",this.getName(), this.getDamage());

	}
	
}
