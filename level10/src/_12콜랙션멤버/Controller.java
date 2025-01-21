package _12콜랙션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Map<Menu, Action> mapList;

    public Controller() {
        mapList = new HashMap<>();
        mapList.put(Menu.INSERT, new ActionInsert());
        mapList.put(Menu.DELETE, new ActionDelete());
        mapList.put(Menu.UPDATE, new ActionUpdate());
        mapList.put(Menu.PRINT, new ActionPrint());
        mapList.put(Menu.SAVE, new ActionSave());
        mapList.put(Menu.LOAD, new ActionLoad());
    }

    public Action getAction(String order) {
        Menu menu = Menu.getMenu(order);
        if (menu == null) {
            System.out.println("잘못된 명령어입니다. 다시 시도해주세요.");
            return null;
        }
        return mapList.get(menu);
    }

    public void run() {
        Utils utils = Utils.getInstance();
        while (true) {
            System.out.println("========== 메뉴 ==========");
            System.out.println("1) 추가"); // ID 중복 방지
            System.out.println("2) 삭제"); // ID 기반 삭제
            System.out.println("3) 수정"); // ID로 검색 -> 비밀번호 확인 -> 이름 수정
            System.out.println("4) 출력"); // 이름순 출력
            System.out.println("5) 저장"); // member.txt에 ID순으로 저장
            System.out.println("6) 로드"); // member.txt에서 로드
            System.out.println("0) 종료");

            int sel = utils.getIntValue("입력>> ", 0, 6);
            switch (sel) {
                case 1:
                    executeAction("insert");
                    break;
                case 2:
                    executeAction("delete");
                    break;
                case 3:
                    executeAction("update");
                    break;
                case 4:
                    executeAction("print");
                    break;
                case 5:
                    executeAction("save");
                    break;
                case 6:
                    executeAction("load");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    utils.closeScanner();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private void executeAction(String order) {
        Action action = getAction(order);
        if (action != null) {
            action.excute();
        }
    }
}
