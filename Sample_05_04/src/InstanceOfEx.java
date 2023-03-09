// instanceof 연산자 활용 
// instanceof 연산자를이용하여 상속 관계에 따라 레퍼런스가 가리키는 객체의 타입을 알아봄 

class Person{}
class Student extends Person {}
class Researcher extends Person {}
class Professor extends Person {}

public class InstanceOfEx {

	static void print(Person p) {
		if (p instanceof Person) {
			System.out.print(" Person ");
		}
		if (p instanceof Student)
			System.out.print(" Student");
		if (p instanceof Professor)
			System.out.print(" Professor");
		System.out.println(" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" new Student() -> \t" );
		print(new Student());
		System.out.println("new Researcher() -> \t");
		print(new Researcher());
		System.out.println(" new Professor() -> \t");
		print(new Professor());
	}

}
