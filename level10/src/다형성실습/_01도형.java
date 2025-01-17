package 다형성실습;

import java.util.Random;

abstract class Shape {
	String name;
	String color;
	double size;

	Shape(String name, String color, int size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	Shape(String name, String color, double size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}

	abstract void draw();

	@Override
	public String toString() {
		return String.format("%s %s (%.2f)", color , name , size);
	}
	
	
}

class Line extends Shape {

	Line( String color, int size) {
		super("선", color,size);
	}

	@Override
	void draw() {
		System.out.println("선을 긋는다 ");
	}

}

class Point extends Shape {

	Point(String color, int size) {
		super("점", color,size);
	}

	@Override
	void draw() {
		System.out.println("점을 찍는다");
	}

}

class Circle extends Shape {

	int radius;

	Circle( String color, int radius) {
		super("원", color,radius*radius*Math.PI );
		this.radius = radius;
	}

	@Override
	void draw() {
		System.out.println("원을 그린다");

	}

}

class Rect extends Shape {

	int height;
	int width;

	Rect( String color, int height, int width) {
		
		super("네모", color, height*width);
		
		this.height = height;
		this.width = width;
	}

	@Override
	void draw() {
		System.out.println("네모를 그린다");
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}

class Triangle extends Shape {
	
	int height;
	int width;
	Triangle(String color, int height , int width) {
		super("세모", color, height * width* 0.5 );
		this.height = height;
		this.width = width;
	}

	@Override
	void draw() {
		System.out.println("세모를 그린다");
	}
}

public class _01도형 {
	public static void main(String[] args) {

		// 모양도 랜덤하게 색깔 사이즈 랜덤해게 도형 10개를 출력하세요 
		// 점 , 선 기존 size 출력 
		// 원, 네모, 세모 => size 넓이를 계산해서 출력 
		
		String[] colors = {"파란색", "빨간색","보라색","분홍색","노란색"};
		
		Shape[] list = new Shape[10];
		
		Rect meno = new Rect(colors[1], 5,10);
		meno.draw();
		System.out.println(meno);
		
		Random rd = new Random();
		int size = 5;
		//[문제1] 10 랜덤하게 생성해서 출력하기 , 사이즈는 랜덤 1~10까지로 설정 
		
		for(int i =0; i < list.length; i+=1) {
			int colorIdx = rd.nextInt(colors.length);
			int rdNum = rd.nextInt(size); // 0 - 4
			if(rdNum == 0) {
				list[i] = new Line( colors[colorIdx] , rd.nextInt(10)+1 );
			}else if(rdNum == 1) {
				list[i] = new Point( colors[colorIdx] , rd.nextInt(10)+1 );
			}else if(rdNum == 2) {
				list[i] = new Circle(colors[colorIdx], rd.nextInt(10)+1);
			}else if(rdNum == 3) {
				list[i] = new Rect(colors[colorIdx], rd.nextInt(10)+1, rd.nextInt(10)+1);
			}else {
				list[i] = new Triangle(colors[colorIdx], rd.nextInt(10)+1, rd.nextInt(10)+1);
				
			}
		}
		
		System.out.println(" [ 문제 1 ] ");
		for(Shape shape : list) {
			shape.draw();
			System.out.println(shape);
		}
		
		System.out.println("------------------");
		System.out.println(" [ 문제 2 ] ");
		//[문제2] 원만 출력하기 
		
		for(Shape shape : list) {
			if(shape instanceof Circle) {
				System.out.println(shape);
			}
		}
		
		
	}
}
