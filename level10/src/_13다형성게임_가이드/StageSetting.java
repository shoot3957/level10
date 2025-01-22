package _13다형성게임_가이드;

import java.util.Scanner;

public class StageSetting extends Stage {

    @Override
    public boolean update() {
        System.out.println("=====[SETTINGS]=====");
        System.out.println("[1.캐릭터 정보 출력] [2.이전으로]");
        Scanner scan = GameManager.scan;
        int sel = scan.nextInt();
        
        if (sel == 1) {
            System.out.println("플레이어 정보:");
            for (Player player : UnitManager.player_list) {
                player.printData();
            }
        } else if (sel == 2) {
            GameManager.nextStage = "LOBBY";
        }
        return false;
    }

    @Override
    public void init() {
        System.out.println("설정 화면 진입...");
    }
}
