// 다음 문장을 수행한 후 z의 값은?

public class Book_page_93_1 {
	public static void main(String[] args) {
		
		int x = 2, y = 10, z = 0;
		z = x++*2+--y-5+x*(y%2);
		
		System.out.println(z);
	}
}
// x++*2 = 4가 나오고 후위 연산자로 x = 3이 된다
// --y-5 에서 y는 후위 연산자로 9가 되며 9 - 5 = 4로 4가 나온다
// x * (y % 2) 에서 y = 9 이므로 9 %  = 1이 나온다
// x = 3이므로 3이 나온다
// 4 + 4 + 3으로 11이 나온다