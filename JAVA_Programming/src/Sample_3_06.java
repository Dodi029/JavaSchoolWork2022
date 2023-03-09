// break 문을 이용하여 while 문 벗어나기 

import java.util.Scanner;

public class Sample_3_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit을 입력하면 종료합니다.");
		while(true) {
			System.out.println(">>");
			String txt = scanner.nextLine();
			
			if(txt.equals("exit"))				// 문자열 비교
				break;
		}
		System.out.println("종료합니다...");
		
		scanner.close();
	}
	
}
