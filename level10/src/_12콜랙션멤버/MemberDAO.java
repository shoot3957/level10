package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private ArrayList<Member> memberList;

    private MemberDAO() {
        memberList = new ArrayList<>();
    }

    private static MemberDAO instance;

    public static MemberDAO getInstance() {
        if (instance == null) instance = new MemberDAO();
        return instance;
    }

    // 기존 코드: ID 중복 체크를 위한 메서드
    public boolean isValidId(String id) {
        return getMemberIdxById(id) == -1;
    }

    // 특정 ID로 멤버 찾기
    private int getMemberIdxById(String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1; // 찾지 못한 경우
    }

    // 회원 추가
    public void addAMember(String id, String pw, String name) {
        memberList.add(new Member(id, pw, name));
    }

    // 회원 목록 가져오기 (출력용)
    public List<Member> getAllMembers() {
        return new ArrayList<>(memberList);
    }

    // 회원 검증 (ID와 비밀번호 확인)
    public boolean validateMember(String id, String pw) {
        int idx = getMemberIdxById(id);
        if (idx != -1) {
            return memberList.get(idx).getPw().equals(pw);
        }
        return false; // 아이디가 존재하지 않거나 비밀번호가 틀림
    }

    // 회원 이름 업데이트
    public void updateMember(String id, String newName) {
        int idx = getMemberIdxById(id);
        if (idx != -1) {
            memberList.get(idx).setName(newName);
        }
    }

    // 회원 정보 출력
    public void printAllMember() {
        for (Member member : memberList) {
            System.out.println(member);
        }
    }
    
    public void saveToFile(BufferedWriter writer) throws IOException {
        for (Member member : memberList) {
            writer.write(member.getId() + "," + member.getPw() + "," + member.getName());
            writer.newLine();
        }
    }
    public void loadFromFile(BufferedReader reader) throws IOException {
        memberList.clear(); // 기존 회원 목록 초기화
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            if (tokens.length == 3) {
                String id = tokens[0].trim();
                String pw = tokens[1].trim();
                String name = tokens[2].trim();
                memberList.add(new Member(id, pw, name));
            }
        }
    }
    public void deleteMember(String id) {
        int idx = getMemberIdxById(id);
        if (idx != -1) {
            memberList.remove(idx); // 해당 인덱스의 회원 삭제
        }
    }
    public boolean isDataExsit() {
        return !memberList.isEmpty();
    }
}