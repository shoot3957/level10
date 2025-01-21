package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActionLoad implements Action {

    MemberDAO dao = MemberDAO.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 정보 로드 ] ====");
        String fileName = Utils.getInstance().getStrValue("불러올 파일명을 입력하세요: ");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            dao.loadFromFile(reader);
            System.out.println("회원 정보가 파일에서 로드되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 로드 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}