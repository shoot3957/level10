package _12콜랙션멤버;

import java.util.List;

public class ActionPrint implements Action {

    MemberDAO dao = MemberDAO.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 목록 출력 ] ====");
        List<Member> members = dao.getSortedMembers(); // DAO에서 정렬된 목록 가져오기

        if (members.isEmpty()) {
            System.out.println("출력할 회원이 없습니다.");
            return;
        }

        System.out.println("====== [ 회원 목록 ] ======");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("==========================");
    }
}