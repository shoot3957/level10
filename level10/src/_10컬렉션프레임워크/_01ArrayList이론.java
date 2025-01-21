package _10컬렉션프레임워크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// 컬렉션 프레임워크 : 데이터 저장 알고리즘을 이미 만든 클래스모음집 

class User implements Comparable<User> {
	String name;
	int age;
	User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name +" "+ age+"\n";
	}
	@Override
	public int compareTo(User o) {
		
		if(age > o.age) {
			return -1;
		}else if(age < o.age){
			return 1;
		}else {
			return name.compareTo(o.name);
		}
		
	}
	
	
}


public class _01ArrayList이론 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		System.out.println(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(list2);
		ArrayList<Integer> list3 = (ArrayList<Integer>) list2.clone();
		System.out.println(list3);
		
		LinkedList<User> list = new LinkedList();
		list.add(new User("홍길동",30));
		list.add(new User("둘리",5));
		list.add(new User("스폰지밥",10));
		list.add(new User("뚱이",12));
		list.add(new User("김치",5));
		list.add(new User("김길순",25));
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		
		
	}
}