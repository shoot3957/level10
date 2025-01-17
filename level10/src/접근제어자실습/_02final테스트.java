package 접근제어자실습;


final class Test{
	int num1;
	int num2;
	Test(int num1 , int num2){
		this.num1 = num1;
		this.num2 = num2;
		
	}
	
	void printNums() {
		System.out.printf(" num1 = %d , num2 = %d \n" , num1,num2);
	}
}
// final 클래스는 상속 받을 수 없다
class Parent{
	int num2 = 20;
	final int num1 = 10; // 초기값 변경이 불가능하다 : 원시타입은 값 변경 불가능 한것
	
	// 메서드에 final 키워드를 붙이면 오버라이딩이 불가능하다 
	final void printNum() {
		System.out.println(num1);
	}
	
}

class Childs extends Parent{
	
// 자식클래스에서 오버라이딩 불가능하다 ㄴ	
//	void printNum() {  // Cannot override the final method from Parent
//		
//	}
}

public class _02final테스트 {
	public static void main(String[] args) {

		final Parent p = new Parent(); // 참조타입 , 새로운 객체로 변경 불가능 
		// 주소값이 변경이 불가능하다 
		// p.num1 = 100;
		p.num2 = 10;
	}
}
