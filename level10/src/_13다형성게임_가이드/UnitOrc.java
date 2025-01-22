package _13다형성게임_가이드;

import java.util.Random;

public class UnitOrc extends Unit {
    UnitOrc() {
        name = "오크";
    }

    @Override
    void skill() {
        System.out.println("[" + name + "] 적 한 명에게 2배 데미지와 기절 효과!");
        int idx = new Random().nextInt(UnitManager.player_list.size());
        Unit target = UnitManager.player_list.get(idx);
        target.curhp -= power * 2;
        target.state = "기절";
        if (target.curhp < 0) {
            target.curhp = 0;
        }
    }
}
