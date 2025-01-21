package MyZombie;

import java.util.Random;
import java.util.Scanner;

public class _MyGameMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyHero hero = new MyHero("용사", 1, 200, 30, 3);
		MyZombie zombie = new MyZombie("좀비", 5, 100, 10);
		MyBoss boss = new MyBoss("보스", 9, 300, 20, 100);
		Random rd = new Random();
		
		int pos = 1;
		while(true) {
			System.out.println("[1] 이동하기 [2] 종료하기");
			int sel = sc.nextInt();
			if(sel == 1) {
				hero.setPos(++pos);
				if(hero.getPos() == zombie.getPos()) {
					System.out.println("좀비를 만났어요");
					
					while(true) {
						zombie.setDamage(zombie.getRd().nextInt(zombie.getPower())+1);
						zombie.attack(hero);
						System.out.println();
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = sc.nextInt();
						if (d == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower()) + 5);
							hero.attack(zombie);
							System.out.println();
						}
						if (d == 2) {
							if (hero.getCount() > 0) {
								hero.potion();
							} else {
								System.out.println("포션이 없습니다.");
							}
						}
						if (zombie.getHp() <= 0) {
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
						int play = sc.nextInt();
						if (play == 1) {
							hero.setDamage(hero.getRd().nextInt(hero.getPower()) + 5);
							hero.bossAttack(boss);
							System.out.println();
						}
						if (play == 2) {
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
			}
			else if(sel==2) {
				break;
			}
		}
	}
}
