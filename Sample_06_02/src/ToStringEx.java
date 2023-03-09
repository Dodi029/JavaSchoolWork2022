// Point 클래스에 toString() 작성
// Point 클래스에 Point 객체를 문자열로 리턴하는 toString() 메소드를 작성하라 

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {						// Point 객체를 문자열로 리턴하는 toString() 작성 
		return "Point(" + x + ", " + y + ")";
	}
}

public class ToStringEx {
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		System.out.println(p.toString());
		System.out.println(p);						// p 는 p.toString() 으로 자동 변환 
		System.out.println(p + "입니다. ");			// p.toString() + "입니다"로 자동 변환 
	}
}