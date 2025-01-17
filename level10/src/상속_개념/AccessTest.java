package 상속_개념;

public class AccessTest {

	public int a = 10; // 같은 프로젝트내에 접근가능 
	int b=20; // 같은 패지키 내에서 접근가능 
	protected int c=30; // 부모 자식클래스만 접근가능 
	private int d= 40; // 자기 자신클래스만 접근가능
	
	public final int num = 100;
	
	protected void printAll() {
		System.out.printf(" %d %d %d %d \n" , a , b , c, d);
	}
	
	
}
