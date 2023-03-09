// HashMap에 객체 저장, 학생 정보 관리 
// id와 전화번호로 구성되는 Student 클래스 작성, 이름을 '키', Student 객체를 '값'인 해시맵 작성 

import java.util.*;

// 학생을 표현하는 클래스 
class Student{
	int id;
	String tel;
	public Student(int id, String tell) {
		this.id = id;
		this.tel = tel;
	}
}

public class HashMapStudentEx {
	public static void main(String[] args) {
		// 학생 이름과 Student 객체를 쌍으로 저장하는 HashMap 컬렉션 생성 
		HashMap<String, Student> map = new HashMap<String, Student>();
		map.put("황기태 ", new Student(1, "010-111-1111")); 			// 학생 저장
		map.put("이제문 ", new Student(2, "010-222-2222"));
		map.put("김남윤 ", new Student(3, "010-333-3333")); 
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색할 이름? : ");						// 사용자로부터 이름 입력 
			String name = scanner.nextLine();
			if(name.equals("exit"))
				break;
			
			Student student = map.get(name);						// 이름으로 Student 객체 검색 
			if(student == null)
				System.out.println(name + "은 없는 사람입니다. ");
			else
				System.out.println("id : " + student.getId() + "전화 : " + student.getTel());
			
		}
		scanner.close();
	}
}
