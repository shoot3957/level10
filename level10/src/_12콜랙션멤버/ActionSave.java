package _12콜랙션멤버;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ActionSave implements Action {

    MemberDAO dao = MemberDAO.getInstance();
    Utils utils = Utils.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 저장 ] ====");
        String fileName = utils.getStrValue("저장할 파일명을 입력하세요: ");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            dao.saveToFile(writer);
            System.out.println("회원 정보가 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}