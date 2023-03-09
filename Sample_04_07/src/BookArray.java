// 객체 배열 만들기
// 예제 4-4의 Book 클래스를 활용하여 2개짜리 Book 객체 배열을 만들고 사용자로부터 책의 제목과 저자를 입력받아 완성

import java.util.Scanner;

class Book {
	String title, author;
	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}
}

public class BookArray{
	public static void main(String[] args) {
		Book [] book = new Book[2];					// Book 배열 선언 
		
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < book.length; i++) {
			System.out.print("제목 : ");
			String title = scanner.nextLine();
			System.out.print("저자 : ");
			String author = scanner.nextLine();
			book[i] = new Book(title, author);		// 배열 원소 객체 생성 
		}
		for (int i = 0; i < book.length; i++)
			System.out.print("(" + book[i].title + ", " + book[i].author + ")");
		
		scanner.close();
	}
}
