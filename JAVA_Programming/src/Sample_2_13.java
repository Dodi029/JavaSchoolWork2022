// 중첩 if - else 문 사례 - 60점 이상이면 합격, 미만이면 불합격, 4학년의 경우 70점 이상이어야 합격

import java.util.Scanner;

public class Sample_2_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0 ~ 100) : ");
		int score = scanner.nextInt();
		System.out.print("학년을 입력하세요(1~4) : ");
		int year = scanner.nextInt();
		
		if (score >= 60) {						// 60점 이상
			if(year != 4)
				System.out.print("합격!");		// 4학년 아니면 합
			else if (score >= 70)
				System.out.print("합격!");		// 4학년이 70점 이상이면 합격
			else
				System.out.print("불합격!");		// 4학년이 70점 미만이면 불합
		}
		else									// 60점 미만 불합
			System.out.print("불합격!");
		
		scanner.close();
	}
}
