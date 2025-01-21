package Zombie;

import java.util.*;

public class _gameMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Hero hero = new Hero("히어로", 1, 200, 30, 2);
		Zombie zombi = new Zombie("좀비", 5, 100, 10);

		//						 pos,hp,power,shield
		Boss boss = new Boss("보스", 9, 300, 20, 100);

		int pos = 1;
		// hero.setPos(pos);
		while (true) {
			System.out.println("현재 위치 = " + pos);	

			System.out.print("앞으로 이동하기(1),종료하기(2) ");

			int move = s.nextInt();

			if (move == 1) {
				hero.setPos(++pos);

				if (hero.getPos() == zombi.getPos()) {
					System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다. ");

					while (true) {
						zombi.setDamage(zombi.getRd().nextInt(zombi.getPower()) + 1);
						zombi.attack(hero);
						System.out.println();
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();
						if (d == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower()) + 5);
							hero.attack(zombi);
							System.out.println();
						}
						if (d == 2) {
							if (hero.getCount() > 0) {
								hero.potion();
							} else {
								System.out.println("포션이 없습니다.");
							}
						}
						if (zombi.getHp() <= 0) {
							System.out.println("좀비를 이겼습니다");
							break;
						}
						if (hero.getHp() <= 0) {
							break;
						}
					}
				}
				if (hero.getPos() == boss.getPos()) {
					System.out.print("보스를 만났습니다. 공격모드로 바뀝니다. ");
					System.out.println();
					while (true) {
						boss.setDamage(boss.getRd().nextInt(boss.getPower()) + 1);
						boss.attack(hero);
						System.out.println();
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();
						if (d == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower()) + 5);
							hero.bossAttack(boss);
							System.out.println();
						}
						if (d == 2) {
							if (hero.getCount() > 0) {
								hero.potion();
							} else {
								System.out.println("포션이 없습니다.");
							}
						}
						if (boss.getHp() <= 0) {
							System.out.println("보스를 이겼습니다");
							break;
						}
						if (hero.getHp() <= 0) {
							break;
						}
					}
				}
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}
				if (hero.getHp() <= 0) {
					System.out.println("히어로가 죽었습니다. 종료합니다.");
					break;
				}

			} else if (move == 2) {
				break;
			}
		}
		s.close();
	}
}