package 상속_개념;

class D {
	int d;
	D(){
		super();
		System.out.println("D 생성!! ");
	}
}
class E extends D{
	int e;
	E(){
		super();
		System.out.println("E 생성!!!");
	}
	
}
class F extends E{
	int f;
	F(){
		super();
		System.out.println(" F 생성!!!");
	}
}


public class _02상속2 {
	public static void main(String[] args) {
		
		F f = new F();
		
	}
}
