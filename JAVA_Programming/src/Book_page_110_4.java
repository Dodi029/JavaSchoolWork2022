// Scanner 클래스로 정수 3개를 입력받고 3개의 숫자 중 중간 크기의 수를 출력하라 ( 평균값 구하는 것이 아님)

import java.util.Scanner;

public class Book_page_110_4 {
	public static void main(String args[]) {
		System.out.println("정수 3개 입력 >>");
		Scanner scanner = new Scanner(System.in);
		
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		
//		if (num1 > num2) {
//			if (num2 > num3) {
//				System.out.println(num2);
//			}
//			else {
//				if (num1 > num3) {
//					System.out.println(num3);
//				}
//				else {
//					System.out.println(num1);
//				}
//			}
//		}
//		
//		else {
//			if (num1 > num3) {
//				System.out.println(num1);
//			}
//			else {
//				if (num2 > num3) {
//					System.out.println(num3);
//				}
//				else {
//					System.out.println(num2);
//				}
//			}
//		}
		
		// -------------------------------------------
		if (num1 > num2 && num1 < num3 || num1 < num2 && num1 > num3) {
			System.out.println(num1);
		}
		else if (num2 > num1 && num2 < num3 || num2 < num1 && num2 > num3) {
			System.out.println(num2);
		}
		else {
			System.out.println(num3);
		}
	}
}
