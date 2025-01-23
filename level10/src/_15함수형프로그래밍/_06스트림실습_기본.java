package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class _06스트림실습_기본 {
	
	public static List<Item> setData(){
		List<Item> itemList = new ArrayList<Item>();

		itemList.add(new Item(1001,"과자", "새우깡", 1500));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1003,"과자", "고래밥", 3000));
		itemList.add(new Item(1004,"음료수", "콜라", 500));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1006,"고기", "돼지고기", 20000));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1008,"과자", "홈런볼", 3500));
		
		return itemList;
	}
	public static void main(String[] args) {
		List<Item> itemList = setData();
		System.out.println(itemList);
		
		//문제 1번 전체 출력
		System.out.println("=====[ 1 ]=====");
		Stream<Item> itemStream = itemList.stream();
		itemStream.forEach(System.out::print);
		//문제 2번 중북된 데이터 제거 후 출력
		System.out.println("=====[ 2 ]=====");
//		itemList.stream()  
//        .filter(isUniqueKey(Item::getItemNo))  
//        .collect(Collectors.toList())
//        .forEach(System.out::print);; 
		itemList.stream()
		.distinct()
		.forEach(System.out::print);
		//문제 3번 카테고리가 과자인 itemList 출력
		System.out.println("=====[ 3 ]=====");
		itemList.stream()
		.filter(i -> i.getCategory().equals("과자"))
		.forEach(System.out::print);
		//문제 4번 카테고리가 고기인 item 갯수 출력
		System.out.println("=====[ 4 ]=====");
		long cnt = itemList.stream()
		.filter(i->i.getCategory().equals("고기"))
		.count();
		System.out.println(cnt);
		//문제 5번 가격이 10000원 이상인 값들의 ArrayList<Item> 만들기
		System.out.println("=====[ 5 ]=====");
		String result = itemList.stream()
				.filter(i -> i.getPrice() > 10000)
				.distinct()
				.map(i -> i+"")
				.collect(Collectors.joining(""));
		System.out.print(result);
		//문제 6번 카테고리가 고기인 아이템 이름만 가져와서 ArrayList<String>으로 만들기
		System.out.println("=====[ 6 ]=====");
		List<String> meats = new ArrayList<>();
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).getCategory().equals("고기")) {
				meats.add(itemList.get(i).getName());
			}
		}
		System.out.println(meats);
		//문제 7번 아이템 번호로 정렬 후 출력
		System.out.println("=====[ 7 ]=====");
		itemList.stream()
				.distinct()
				.sorted(Comparator.comparing(Item::getItemNo))
				.forEach(System.out::print);
		//문제 8번 아이템 가격 순으로 정렬
		System.out.println("=====[ 8 ]=====");
		itemList.stream()
		.distinct()
		.sorted(Comparator.comparing(Item::getPrice))
		.forEach(System.out::print);
		
	}

}