// Object 클래스로 객체 속성 알아내기 
// 객체 레퍼런스만으로 객체의 클래스명, 해시코드 값, 객체의 문자열을 출력해보자 

class Point{
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class ObjectPropertyEx {

	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());		// 클래스 이름 
		System.out.println(obj.hashCode());					// 해시 코드 값 
		System.out.println(obj.toString());					// 객체를 문자열로 만들어 출력 
		System.out.println(obj);							// 객체 출력 
	}
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);
	}
}
