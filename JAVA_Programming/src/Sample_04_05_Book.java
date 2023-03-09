// 생성자 선언 및 활용 연습
// 제목과 저자를 나타내는 title과 author 필드를 가진 Book 클래스를 작성하고, 생성자를 작성하여 필드를 초기화 

public class Sample_04_05_Book {
	String title;
	String author;
	void show() {System.out.println(title + " " + author);}
	public Sample_04_05_Book() {
		this("", "");
		System.out.println("생성자 호출됨");
	}
	
	public Sample_04_05_Book(String t) {					// 생성자 
		title = t;
		author = "작자미상";
	}
	public Sample_04_05_Book(String t, String a) {			// 생성자 
		title = t;
		author = a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample_04_04_Book littlePrince = new Sample_04_04_Book("어린왕자", "생텍쥐페리");
		Sample_04_04_Book loveStory = new Sample_04_04_Book("춘향전");
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
	}

}
