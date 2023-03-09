// main()에서 명령행인자의 합 계산 - 사용자가 명령행에 입력한 여러 개의 실수를 main() 메소드에서 전달받아 합을 
// 구하는 프로그램을 작성


public class Sample_3_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		for (int i = 0; i < args.length; i++)		// 인자 개수만큼 반복
			
			// 문자열을 실수(double타입)로 변환하여 합
			sum += Double.parseDouble(args[i]);
		System.out.println("합계 : " + sum);
	}
}

