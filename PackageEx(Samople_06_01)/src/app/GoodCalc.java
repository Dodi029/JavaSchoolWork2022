package app;
import lib.Calculator;

//추상 클래스의 구현 연습
//다음 추상 클래스 Calculator를 상속받은 GoodCalc 클래스를 구현하라 

public class GoodCalc extends Calculator {
	public int add(int a, int b) {					// 추상 메소드 구현 
		return a + b;
	}
	
	public int substract(int a, int b) {			// 추상 메소드 구현 
		return a - b;
	}
	
	public double average(int[] a) {				// 추상 메소드 구현 
		double sum = 0;
		for (int i = 0; i <a.length; i++)
			sum += a[i];
		return sum/a.length;
	}
	
	public static void main(String[] args) {
		GoodCalc c = new GoodCalc();
		// Calculator c = new GoodCalc();			// 이렇게 써도 괜찮음 
		System.out.println(c.add(2, 3));
		System.out.println(c.substract(2,3));
		System.out.println(c.average(new int[] {2,3,4}));
	}
}
