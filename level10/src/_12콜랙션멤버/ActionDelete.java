package _12콜랙션멤버;

public class ActionDelete implements Action {

    MemberDAO dao = MemberDAO.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 삭제 ] ====");
        String id = Utils.getInstance().getStrValue("삭제할 회원의 아이디를 입력하세요: ");
        
        if (dao.isValidId(id)) {
            System.out.println("존재하지 않는 아이디입니다.");
        } else {
            dao.deleteMember(id);
            System.out.println("회원 삭제가 완료되었습니다.");
        }
    }
}