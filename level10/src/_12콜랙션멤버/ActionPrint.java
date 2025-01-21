package _12콜랙션멤버;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActionPrint implements Action {

    MemberDAO dao = MemberDAO.getInstance();
    Utils utils = Utils.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 목록 출력 ] ====");
        List<Member> members = dao.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("출력할 회원이 없습니다.");
            return;
        }

        // 이름순 정렬
        Collections.sort(members, Comparator.comparing(Member::getName));
        
        System.out.println("====== [ 회원 목록 ] ======");
        for (Member member : members) {
            System.out.println(member);
        }
        System.out.println("==========================");
    }
}