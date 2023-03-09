// 타입 변환 - 자동 타입 변환과 강제 타입 변환의 이해를 위한 예제

public class Sample_2_3 {		// TypeConversion
	public static void main(String[] args) {
		byte b = 127;
		int i = 100;
		
		System.out.println(b+i);					// 227
		System.out.println(10/4);					// 2
		System.out.println(10.0/4);					// 2.5
		System.out.println((char)0x12340041);		// A
		System.out.println((byte)(b+i));			// -29
		System.out.println((int)2.9 + 1.8);			// 3.8
		System.out.println((int)(2.9 + 1.8));		// 4
		System.out.println((int)2.9 + (int)1.8);	// 3
	}
}
