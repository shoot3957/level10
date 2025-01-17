package 추상_개념;

// 부모클래스 == 상위클래스 == 슈퍼클래스
abstract class Parent{
	int a=10;
	int b=20;
	
	abstract void test();
}
// 자식클래스 == 하위클래스 == 서브클래스 
class Child extends Parent{
	int c=30;
	int d=40;
	@Override
	void test() {
		
	}
}
public class _02추상클래스2 {
	public static void main(String[] args) {
		// casting : 형변환 
		// 강제 형변환 
		System.out.println( (int)10.2345); // 10
	//	Parent p = new Parent();
		Child c = new Child();
		
		int num = 10;
		
		// upcasting  : 하위클래스가 상위타입 전환 : 자식클래스 객체가 부모 클래스 객체 전환 
		Parent parent = new Child(); // 업케스팅 
		
		// downcasting : 상위클래스를 하위타입 변환?? 
		// Child child = new Parent();
		Child child = (Child)parent; 
	}
}
