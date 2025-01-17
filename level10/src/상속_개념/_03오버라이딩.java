package 상속_개념;

// super class
// 부모클래스 , 슈퍼 클래스 , 상위 클래스 
class Parent{
	int num = 100;
	void test1() {
		System.out.println("test1 호출!!!!");
	}
	void printNum() {
		System.out.println("num=" + num);
	}
}

// sub class
// 자식클래스, 서브클래스 , 하위클래스 
class Child extends Parent{
	int num = 200; 
	void test2() {
		System.out.println("test2 호출!!!!");
	}
	
	void printNum() {
		System.out.println("num=" + num);
		System.out.println("부모num 호출 = " + super.num );
	}
	
	@Override
	void test1() {
		System.out.println("자식이 변경한 test1호출!!!!");
	}
}



public class _03오버라이딩 {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		Child c = new Child();
		
		p.test1();
		c.printNum();
		c.test1();
		
	}
}
