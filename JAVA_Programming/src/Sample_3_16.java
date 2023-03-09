// 범위를 벗어난 배열의 접근 - 배열의 인덱스가 범위를 벗어날 때 발생하는
// ArrayIndexOutOfBoundsExpception을 처리하는 프로그램을 작성 
public class Sample_3_16 {
	public static void main(String[] args) {
		int [] intArray = new int[5];
		intArray[0] = 0;
		try {
			for (int i = 0; i <5; i++) {
				intArray[i + 1] = i + 1 + intArray[i];
				System.out.println("intArray["+i+"]"+"="+intArray[i]);
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
		}
	}
}