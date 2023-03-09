// 제네릭 스택 만들기 
// 스택을 제네릭 클래스로 작성하고, String과 Integer형 스택을 사용하는 얘를 보여라 

class GStack<T>{
	int tos;
	Object [] stck;
	public GStack() {
		tos = 0;
		stck = new Object [10];
	}
	public void push(T item) {
		if (tos == 10)
			return;
		stck[tos] = item;
		tos ++;
	}
	public T pop() {
		if(tos == 0)
			return null;
		tos--;
		return (T)stck[tos];
	}
}

public class MyStack {
	public static void main(String[] args) {
		GStack <String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		for (int n = 0; n < 3; n++)
			System.out.println(stringStack.pop());
		
		GStack<Integer> intStack = new GStack<Integer>();
		
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		for (int n = 0; n < 3; n++)
			System.out.println(intStack.pop());
	}
}
