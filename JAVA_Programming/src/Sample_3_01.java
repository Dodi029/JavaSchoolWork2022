// for 문을 이용하여 1부터 10까지 합 출력

public class Sample_3_01 {
	public static void main(String[] args) {
		int sum = 0;
		
	for(int i = 1;i <= 10;i++) {			// 1부터 10까지 반
			sum += i;
			System.out.println(i);				// 더하는 수 출
			
			if (i <= 9)							// 1 ~ 9까지는 '+' 출
				System.out.println("+");
			else {								// i가 10인 경
				System.out.println("=");		// '=' 출력하
				System.out.println(sum);		//덧셈 결과 출
			}
		}
	}
}
