package _13다형성게임_가이드;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	Random ran = new Random();
    static Scanner scan = new Scanner(System.in);
    static String nextStage = "";
    String curStage = "";
    Map<String, Stage> stageList = new HashMap<>();
    UnitManager unitManager = new UnitManager(); // UnitManager 인스턴스 생성

    GameManager() {
        stageList.put("TITLE", new StageTitle());
        stageList.put("BATTLE", new StageBattle(unitManager)); // 전달
        stageList.put("LOBBY", new StageLobby());
        nextStage = "TITLE";
    }

	boolean changeStage() {
		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (true) {
			run = stage.update();
			if (run == false)
				break;
		}

		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

}