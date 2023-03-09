// Super()를 활용한 ColorPoint 작성 
// ColorPoint 클래스의 생성자에서 슈퍼 클래스 Point의 생성자를 호출하는 예 

class Point{
	private int x, y;										// 한 점을 구성하는 x, y 좌표 
	public Point() {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void showPoint() {								// 점의 좌표 츌력 
		System.out.println("(" + x + ", " + y + ")");
	}
}

class ColorPoint extends Point{
	private String color;									// 점의 색 
	public ColorPoint(int x, int y, String color) {
		super(x, y);										// Point의 생성자 Point(x, y) 호출 
		this.color = color;
	}
	public void showColorPoint() {							// 컬러 점의 좌표 출력 
		System.out.print(color);
		showPoint();										// Point 클래스의 showPoint() 호출 
	}
}

public class SuperEx {
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 6, "blue");
		cp.showColorPoint();
	}
}
