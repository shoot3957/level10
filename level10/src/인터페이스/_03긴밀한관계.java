package 인터페이스;

// 클래스 AA 클래스 BB는 긴밀한 관계를 가지고 있다 
// 메서드A 호출하려면 반드시 BB가 있어야한다 

// 클래스랑 클래스 간에 결속이 높으면 가독성 좋지만 유지보수가 어렵다
class AA{
	void methodA( CC c) {
		System.out.println("메서드 a 호출 ");
		//b.methodB();
		c.methodC();
	}
}
class BB{
	void methodB() {
		System.out.println("메서드 b 호출");
	}
}
class CC{
	void methodC() {
		System.out.println("메서드 c 호출");
	}
}


public class _03긴밀한관계 {
	public static void main(String[] args) {
		AA a = new AA();
		
		//a.methodA(new BB());
		a.methodA(new CC());
	}
}
