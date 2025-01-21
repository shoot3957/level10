package _12콜랙션멤버;

public class ActionUpdate implements Action {

    MemberDAO dao = MemberDAO.getInstance();
    Utils utils = Utils.getInstance();

    @Override
    public void excute() {
        System.out.println("==== [ 회원 수정 ] ====");
        String id = utils.getStrValue("수정할 회원의 아이디를 입력하세요: ");
        String pw = utils.getStrValue("비밀번호를 입력하세요: ");
        
        if (dao.validateMember(id, pw)) {
            String newName = utils.getStrValue("새로운 이름을 입력하세요: ");
            dao.updateMember(id, newName);
            System.out.println("회원 정보가 수정되었습니다.");
        } else {
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }
}