package Zombie;

// 보스인지 아닌지 구분해서 공격 

// 히어로는 체력 포션으로 100 체력 회복할 수 있고 체력 포션이 없으면 체력 회복이 안된다 
// 외부의 적은 보스인지 아닌지 구별해서 공격 해야한다 
// 보스이면 보호막을 가지고 있다 먼저 보호막을 다 뚫어야지만 직접 보스를 공격할 수 있다. 
// 일반 적은 보호막 가지고 있지 않음 

public class Hero extends Unit {
	
	private int count;
	
	public int getCount() {
		return count;
	}

	public Hero(String name, int pos, int hp, int power, int count) {
		super(name, pos, hp, power);
		this.count = count;
	}
	
	public void potion() {
		count -= 1;
		System.out.println("체력 100 회복");
		this.setHp(this.getHp()+100);
	}
	
	public void bossAttack(Boss boss) {
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