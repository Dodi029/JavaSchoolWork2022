// for-each 문 활용 

public class Sample_3_09 {
	enum Week{ 월, 화, 수, 목, 금, 토, 일 
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] n = { 1, 2, 3, 4, 5 };
		String names[] = { "사과", "배", "바나나", "체리", "딸기", "포도" };
		
		int sum = 0;
		// 아래 for-each에서 k는 n[0], n[1], ... , n[4]로 반복
		for (int k : n) {
			System.out.println(k + " ");			// 반복되는 k 값 출력
			sum += k;
		}
		System.out.println("합은 " +sum);
		
		// 아래 for-each에서 s는 name[0], name[1], ... , name[5]로 반복
		for (String s : names)
			System.out.println(s + " ");
		System.out.println();
		
		// 아래 for-each에서 day는 월, 화, 수, 목, 금, 토, 일 값으로 반복
		for (Week day : Week.values())
			System.out.println(day + "요일");
		System.out.println();
	}

}
