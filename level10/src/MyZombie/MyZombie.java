package MyZombie;

public class MyZombie extends MyUnit{
	
	public MyZombie(String name, int pos, int hp, int power) {
		super(name, pos, hp, power);
		// TODO Auto-generated constructor stub
	}
	
	public void attack(MyUnit unit) {
		super.attack(unit);
		super.setHp(this.getHp()+this.getDamage()/2);
		if(this.getHp()>this.getMAX_HP()) {
			this.setHp(getMAX_HP());
		}
		System.out.print(" " + this.getName() + "가 체력 회복" + this.getHp());
	}
	
	
}
