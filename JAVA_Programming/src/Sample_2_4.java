// Scanner를 이용한 키 입력 연습 - 이름, 도시, 나이, 체중, 독신 여부를 입력 받고 다시 출력하는 프로그램을 작성하

import java.util.Scanner;

public class Sample_2_4 {
	public static void main(String args[]) {
		System.out.println("이름, 도시, 나이, 체중ㄹ, 독신 여부를 빈칸으로 분리하여 입력하세요 ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("이름은 " + name + ", ");
		String city = scanner.next();
		System.out.println("도시는 " + city + ", ");
		
	}
}
