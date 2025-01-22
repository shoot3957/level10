package _13다형성게임_가이드;

import java.util.Random;

public class UnitBat extends Unit {
    UnitManager unitManager; // UnitManager 인스턴스 변수 추가

    UnitBat(UnitManager unitManager) { // UnitManager 객체를 매개변수로 받는 생성자
        name = "박쥐";
        this.unitManager = unitManager; // 생성자에서 UnitManager 인스턴스 할당
    }

    @Override
    void skill() {
        System.out.println("[" + name + "] 적 한 명에게 침묵을 시전!");
        int idx = new Random().nextInt(unitManager.player_list.size()); // unitManager를 통해 player_list에 접근
        Unit target = unitManager.player_list.get(idx);
        target.state = "침묵";
    }
}