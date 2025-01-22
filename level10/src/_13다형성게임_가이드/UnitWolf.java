package _13다형성게임_가이드;
public class UnitWolf extends Unit {
    UnitWolf() {
        name = "늑대";
    }

    @Override
    void skill() {
        System.out.println("[" + name + "] 적 전체에게 공격력의 절반 데미지!");
        for (Unit player : UnitManager.player_list) {
            player.curhp -= power / 2;
            if (player.curhp < 0) {
                player.curhp = 0;
            }
        }
    }
}
