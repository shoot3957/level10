package 다형성실습;

import java.util.ArrayList;
import java.util.Random;

/*
 * damage() 메소드를 가진
 * Interface Damageable를 정의하고
 * 최하위 유닛을 (모든)에게 Damageable 상속
 * main에서 각각의 유닛을 손상시킨 후 repair() 돌려보기
 */
interface Repairable {
}
	
interface Damageable {
	void damage(Damageable damageable, int damage);
}

class Unit implements Damageable {
	final int MAX_HP;
	int hp;
	int damage;
	String name;
	static int count = 0;
	
	public Unit(int hp, String name,int cnt) {
		MAX_HP = hp;
		this.hp = MAX_HP;
		this.name = name+String.valueOf(cnt);
	}

	@Override
	public void damage(Damageable damageable, int damage) {
		Unit unit = (Unit) damageable;
		System.out.println(unit + "이(가) " + damage + "의 데미지를 입었다.");
		unit.hp -= damage;
		// TODO Auto-generated method stub
	}
}

class SCV extends Unit implements Repairable {
	public SCV(int cnt) {
		super(200,"SCV",cnt);
	}

	void repairUnit(Repairable repairable) {
		Unit unit = (Unit) repairable;

		unit.hp = unit.MAX_HP;
		System.out.println(unit + " 수리 완료");
	}

	@Override
	public String toString() {
		return String.format("%s (%d/%d)",name, hp, MAX_HP);
	}
}

class Tank extends Unit implements Repairable {
	public Tank(int cnt) {
		super(250,"Tank",cnt);
	}

	@Override
	public String toString() {
		return String.format("%s (%d/ %d )",name, hp, MAX_HP);
	}

}
class unitDAO{
	ArrayList<Unit> units = new ArrayList<>();
	void make10Unit() {
		for (int i = 0; i < 5; i++) {
			units.add(new Tank(i+1));
			Unit.count++;
		}
		for (int i = 0; i < 5; i++) {
			units.add(new SCV(i+1));
			Unit.count++;
		}
	}
	boolean dead(int attacked, int attacker) {
		if (units.get(attacked).hp <= 0) {
			System.out.println(units.get(attacked).toString() + " 사망");
			units.remove(attacked);
			Unit.count--;
			return true;
		}
		return false;
	}
	void attack(int attacker, int attacked, int damage) {
		System.out.print(units.get(attacker).toString() + " 공격!\t");
		units.get(attacker).damage(units.get(attacked), damage);
	}
	void fight() {
		Random rd = new Random();
		while (Unit.count > 1) {
			int unit1 = rd.nextInt(Unit.count);
			int unit2 = rd.nextInt(Unit.count);
			int damage1 = rd.nextInt(20)+10; 
			int damage2 = rd.nextInt(20) + 10;
			if (unit1 != unit2) {
				attack(unit1, unit2, damage1);
				if(!dead(unit2, unit1)) { //attacked가 죽었으면? count-- remove 해주고 true리턴
					attack(unit2, unit1, damage2); // 안죽었으니까 반격
					dead(unit1, unit2);
				} 
				System.out.println();
			}
		}
		System.out.println("최후의 승자 " + units.get(0));
	}
}

public class _02스타크래프트 {
	public static void main(String[] args) {
		unitDAO unitDAO = new unitDAO();
		// 10개 유닛 만들어서
		// 서로 랜덤하게 공격하다가
		// 한명 살아남을 떄까지 반복
		unitDAO.make10Unit();
		unitDAO.fight();
	}
}