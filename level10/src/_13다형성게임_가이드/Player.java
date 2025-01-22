package _13다형성게임_가이드;

public class Player extends Unit {

    Player(String na, int max, int pow) {
        super(na, max, pow);
    }

    @Override
    void skill() {
        System.out.println("[" + name + "] 특수 스킬 사용! 전체 체력을 10% 회복합니다.");
        curhp += maxhp * 0.1;
        if (curhp > maxhp) {
            curhp = maxhp;
        }
    }
}
