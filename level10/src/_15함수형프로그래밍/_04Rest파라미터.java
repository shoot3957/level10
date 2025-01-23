package _15함수형프로그래밍;

import java.util.Arrays;
import java.util.List;

public class _04Rest파라미터 {
	// 매개변수 갯수를 모를때 사용한다
	public static int getSum(int ...nums) { //int[] nums
		int sum = 0;
		for(int i=0;i<nums.length;i++) sum+=nums[i];
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(getSum());
		System.out.println(getSum(10));
		System.out.println(getSum(10,20,30));
		System.out.println(getSum(10,20,30,40,50));
		
		List<String> list =  Arrays.asList("강아지", "고양이", "사자","토끼");
		
		for(String element : list) System.out.println(element);
		System.out.println("------------");
		
		//리스트의 요소를 처음부터 끝까지 한개씩 꺼내오는 메서드 -> 함수형 인터페이스 사용
		list.forEach(element -> System.out.println(element));
		System.out.println("-------------");
		
		//사용할 클래스 객체 :: 메서드 이름 -> 매개변수값 생략
		list.forEach(System.out::println);
	}
}
