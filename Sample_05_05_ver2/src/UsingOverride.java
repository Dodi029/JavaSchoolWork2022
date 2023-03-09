// 오버라이딩 활

class Shape {								// 슈퍼 클래스 
	public Shape next;
	public Shape() {next = null;}
	
	public void draw() {
		System.out.println(" Shape ");
	}
}

class Line extends Shape {
	public void draw() {					// 메소드 오버라이딩 
		System.out.println(" Line ");
	}
}

class Rect extends Shape {
	public void draw() {					// 메소드 오버라이딩 
		System.out.println(" Rect ");
	}
}

class Circle extends Shape {
	public void draw() {					// 메소드 오버라이딩 
		System.out.println(" Circle ");
	}
}

public class UsingOverride {
	public static void main(String[] args) {
		Shape start, last, obj;				// 링키드 리스트로 도형 생성하여 연결 
		
		start = new Line();					// Line 객체 연결 
		last = start;
		obj = new Rect();
		last.next = obj;					// Rect 객체 연결 
		last = obj;
		obj = new Line();					// Line 객체 연결 
		last.next = obj;
		last = obj;
		obj = new Circle(); 				// Circle 객체 연결 
		last.next = obj;
							
		Shape p = start;
		
		while(p != null) {					// 모든 도형 연결 
			p.draw();
			p = p.next;
		}
	}
}
