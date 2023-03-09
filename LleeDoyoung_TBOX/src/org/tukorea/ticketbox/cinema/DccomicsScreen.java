package org.tukorea.ticketbox.cinema;

public class DccomicsScreen extends Screen {					// Screen의 서브 클래스 생성 
	public DccomicsScreen(String name, String story, int price, int row, int col) {
		super(name, story, price, row, col);		// 생성자 직접 선언 - 매개변수가 있기 때문에 기본 생성자를 사용하지 않음 
	}
	
	public void showMovieInfo() {							// 영화 정보 출력 
		System.out.println(" ---------------------");
		System.out.println("\t" + this.movieName + " 소개");
		System.out.println(" ---------------------");

		System.out.println(" 영화관 : DC 영화 1관 ");
		System.out.println(" 줄거리 :  " + this.movieStory);
		System.out.println(" 가격 : " + this.ticketPrice);

	}
}
