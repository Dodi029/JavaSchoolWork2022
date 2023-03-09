package org.tukorea.ticketbox.cinema;

public class FamillyScreen extends Screen {						// Screen의 서브 클래스 생성 
	public FamillyScreen(String name, String story, int price, int row, int col) {
		super(name, story, price, row, col);				// 생성자 직접 선언 - 매개변수가 있기 때문에 기본 생성자를 사용하지 않음 
	}
	
	public void showMovieInfo() {
		System.out.println(" ---------------------");
		System.out.println("\t" + this.movieName + " 소개");
		System.out.println(" ---------------------");

		System.out.println(" 영화관 : 가족 영화 2관 ");
		System.out.println(" 줄거리 :  " + this.movieStory);
		System.out.println(" 가격 : " + this.ticketPrice);
	}
}
