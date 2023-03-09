// StringBuffer 클래스 메소드 활용 
// StringBuffer를 이용하여 문자열을 조작하는 다음 코드의 실행 결과는? 
public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		
		sb.append(" is pencil");		// 문자열 덧붙이기 
		System.out.println(sb); 		
		
		sb.insert(7,  "my"); 			// "my" 문자열 삽입 
		System.out.println(sb); 		
		
		sb.replace(8, 10, "Your");		// "my"를 "Your"로 변경 
		System.out.println(sb);
		
		sb.delete(8, 13);				// "Your" 삭제 
		System.out.println(sb);
		
		sb.setLength(4);				// 스트링 버퍼 내 문자열 길이 수정 
		System.out.println(sb);
	}
}
