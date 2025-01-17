package 인터페이스;

// 추상클래스 vs 인터페이스 
//  인터페이스는 다중상속이 목적이다
// 인테페이스는 객체 따로 못만든다 , 추상클래스보다 더 추상적이다 
// 인터페이스 자체는 객체를 생성하는 것이 목적이 아니다! 

// 추상클래스 : 동물 식물 기계
// 인터페이스 : movable() flyable() eatable() swimable() aboardable()

// 자동차 : 기계 : movable(), aboardable() 
// 새 : 동물 : flyable(),movable() , eatable(), swimable()
// 사람 : 동물 :  movable(),swimable(),  eatable()
// 오리배 : 기계 : movable(), swimable(),aboardable()
// 연꽃 : 식물 : swimable() , 

/*
  		    	추상클래스 			    |		인터페이스
 개녕     | 물려 받는 것(혈통, 가문, 계열)	| 장착한다 (기능, 행위, 학위 , 자격증 )
 다중적용  | 불가능 (부모는 하나 )          | 가능 
 생성자    |    가짐       				|  가지지 않음
 메서드    |  완성된 메서드, 미완성 메서드    | 추상메서드 , default( 완성된 메서드) , static( 완성된 메서드)
 필드(멤버변수) |  모든 필드     			|  상수 (public final static 자료형타입 )  
 적용 방식     |  extends (확장)   		|  implements (구현 )
  
 
 
 */



class A{
	int num;
	final int num2=10;
	
}

abstract class B{
	int num = 10;
	abstract void test1();
	B(){
		
	}
}

// 추상클래스보다 더 추상적인 것 => 인터페이스 => 여러개를 상속하려고 
//인터페이스에서 멤버 변수는 무조건 상수 
interface C{
	int num=10;  // public static final int num = 10;
	void test1(); // public abstract void test1();
//	C(){
//		
//	}
	 default void test2() {
		
	}
	
}

interface D{
	void test2();
}


class F extends A implements C, D{

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}
	
}

interface G extends D{
	
}

public class _01인터페이스 {
	public static void main(String[] args) {
	
	}
}
