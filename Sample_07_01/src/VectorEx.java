// 정수만 다루는 Vector<integer> 컬렉션 활용 
// 정무만 다루는 벡터를 생성하고, 활용하는 기본 사례를 보임 

import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		// 정수 값만 다루는 제네릭 벡터 생성 
		Vector<Integer> v = new Vector<Integer>();
		
		v.add(5);			// 5삽입
		v.add(4);			// 4삽입
		v.add(-1);			// -1삽입 
//		v.add(1);
//		v.add(2);
//		v.add(3);
//		v.add(4);
//		v.add(5);
//		v.add(6);
//		v.add(7);
		
		// 벡터 중간에 삽입하기 
		v.add(2,100);		// 4와 -1사시에 정수 100 삽입 
		
		System.out.println("벡터 내의 요소 객체 수 : " + v.size());
		System.out.println("벡터의 현재 용량 : " + v.capacity() );
		
		// 모든 요소 정수 출력하기 
		for (int i = 0; i < v.size(); i++) {
			int n = v.get(i);
			System.out.println(n);
		}
		// 벡토 속의 모든 정수 더하기 
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			int n = v.elementAt(i);
			sum += n;
		}
		System.out.println("벡터에 있는 정수 합 : " + sum);
	}
}
