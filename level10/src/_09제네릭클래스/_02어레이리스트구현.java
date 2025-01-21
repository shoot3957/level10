//package _09제네릭클래스;
//
//import java.util.Arrays;
//
//class MyArrayList<T>{
//	private T[] arr;
//	private int size;
//	private int capacity;
//	private final int DEFAULT_CAPACITY = 10;
//	
//	MyArrayList(){
////		arr = new T[10]; // 제네릭 클래스로 배열 선언을 할 수 없다
//		arr = (T[]) new Object[DEFAULT_CAPACITY];
//	}
//	public void print() {
//		System.out.println(Arrays.toString(arr));
//	}
//	public int size() {
//		return size;
//	}
//	public int capacity() {
//		return capacity;
//	}
//	public void add(Object O) {
//		if(size==capacity) {
//			capacity+=10;
//			Object[] temp = arr;
//			arr = (T[]) new Object[capacity];
//			for(int i=0;i<size;i++) {
//				arr[i] = (T) temp[i];
//			}
//		}
//		arr[size] = (T) O;
//		size++;
//	}
//	public void add(int idx, Object O) {
//		if(size==capacity) {
//			capacity+=10;
//			Object[] temp = arr;
//			arr = (T[]) new Object[capacity];
//		}
//	}
//	public Object get(int idx) {
//		
//		return arr[idx];
//		
//	}
//	public void set(int idx, Object O) {
//		arr[idx]  =(T) O;
//	}
//}
//public class _02어레이리스트구현 {
//	public static void main(String[] args) {
//		MyArrayList<Double> v1 = new MyArrayList<>();
//		
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//		
//		for(int i=0;i<10;i++) {
//			v1.add((i+1)*10*1.0);
//		}
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//		System.out.println(v1.get(1));
//		
//		v1.set(1, 1000.0);
//		System.out.println(v1);
//		
//		v1.add(1,20.0);
//		System.out.println(v1);
//		
//		v1.remove(3);
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//		
//		v1.clear();
//		System.out.println(v1);
//		System.out.println(v1.size());
//		System.out.println(v1.capacity());
//	}
//}
