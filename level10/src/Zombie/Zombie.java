package Zombie;


// 좀비는 히어로 공격 가능하고 한턴이 지날때마다 공격한 대미지의 50%를 회복하는 능력을 가지고 있다 
public class Zombie extends Unit {
	
	public Zombie(String name, int pos,int hp,int power) {
		super(name, pos,hp,power);
	}
	
	public void attack(Unit unit) {
		super.attack(unit);
		super.setHp(this.getHp()+this.getDamage()/2);
		if(this.getHp() > this.getMAX_HP()) {
			this.setHp(getMAX_HP());
		}
		System.out.print(" " + this.getName() + "가 체력 회복" + this.getHp());
	}
}