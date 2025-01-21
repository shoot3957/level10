package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

   
    public boolean isValidId(String id) {
        return getMemberIdxById(id) == -1;
    }

    private int getMemberIdxById(String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1; 
    }


    public void addAMember(String id, String pw, String name) {
        memberList.add(new Member(id, pw, name));
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(memberList);
    }

 
    public boolean validateMember(String id, String pw) {
        int idx = getMemberIdxById(id);
        if (idx != -1) {
            return memberList.get(idx).getPw().equals(pw);
        }
        return false; 
    }


    public void updateMember(String id, String newName) {
        int idx = getMemberIdxById(id);
        if (idx != -1) {
            memberList.get(idx).setName(newName);
        }
    }


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
        memberList.clear(); 
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
            memberList.remove(idx); 
        }
    }
    public boolean isDataExsit() {
        return !memberList.isEmpty();
    }
    public List<Member> getSortedMembers() {
        List<Member> sortedList = new ArrayList<>(memberList); // 복사본 생성
        Collections.sort(sortedList, Comparator.comparing(Member::getName)); // 이름순 정렬
        return sortedList;
    }
}