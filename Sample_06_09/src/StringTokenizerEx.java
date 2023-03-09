// StringTokenizer 클래스 메도스 활용 
// "홍길동/장화/홍련/콩쥐/팥쥐: 문자열을 '/'를 구분 문자로 하여 토큰을 분리하여 각 토큰을 출력 

import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐","/");
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}
