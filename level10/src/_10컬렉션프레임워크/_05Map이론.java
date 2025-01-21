package _10컬렉션프레임워크;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _05Map이론 {
	public static void main(String[] args) {
		   // key(사용자정의 인덱스 ) , value
		
		// KEY 값은 중복을 허용하지않는다!! , 여러개 들어가는 배열도 허용하지 않음
		// value 여러 타입 허용 가능 
		
		Map<String, Integer> list = new HashMap<>();
		list.put("apple", 10000);
		list.put("orange", 3000);
		list.put("melon", 20000);
		list.put("banana", 1000);
		
		System.out.println(list);
		list.put("apple", 4000); // 덮어쓰기 
		System.out.println(list);
		
		System.out.println(list.get("orange"));
		
		Set<String> keyList =  list.keySet();
		
		for(String s : keyList) {
			System.out.println(s);
		}
		
		System.out.println(list.containsKey("apple"));
		System.out.println(list.containsKey("waterMelon"));
		System.out.println(list.containsValue(3000));
		
		
		Set<Map.Entry<String, Integer>> list2 = list.entrySet();
		
		for(Map.Entry<String, Integer> entry : list2) {
			System.out.println(entry);
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
		
		
		
	}
}