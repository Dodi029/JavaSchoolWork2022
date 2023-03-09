package org.tukorea.ticketbox.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.tukorea.ticketbox.cinema.Screen;

public class TicketBoxMain {
	public static void main(String[] args) {
		TicketBox ticketBox = new TicketBox();		// 갹체 생성 
		Scanner scan = new Scanner(System.in);		// Scanner 객체 생성 
		Screen screen = null;
		boolean mainMenu = true;				// 상영관 선택 메뉴 사용 	
		ticketBox.initScreen();					// 3개의 스크린 객체를 생성 
		
		while(true) {
			if (mainMenu) {			// mainMenu가 true이므로 조건문 실행 
				screen = ticketBox.selectScreen();		// tickBox의 selectScreen 출력 
				if (screen == null) {					// screen = null이면 
					System.out.print(" 안녕히 가세요! ");		// 메시지 출력 
					scan.close();						// scanner 객체를 닫고 
					System.exit(0);						// 프로그램 종료 
				}
				mainMenu = false;						// 조건문을 탈출하기 위해 false 저장 
			}
			
			screen.showScreenMenu();					// 메인메뉴 출력 
			System.out.print(" 메뉴를 선택하세요 >> ");		// 메뉴를 선택하라는 메시지 출력 
			try {										// 오류를 잡기위해 try문 사용 
				int select = scan.nextInt();			// 입력한 숫자를 select에 정수형으로 저장 
				switch(select) {						// 입력한 숫자에 따라 다른 코드 실행 
				
				case 1:							// 스크린 상영 영화 정보 보기 
					screen.showMovieInfo();	
					break;
					
				case 2:							// 좌석 예약 현황 보기 
					screen.showSeatMap();
					break;
					
					
				case 3:							// 좌석 예약 하기 
					screen.reserveTicket();	
					break;
					
				case 4:							// 예약 취소하기 
					screen.cancelReservation();	
					break;
					
				case 5:							// 좌석 결제 하기 
					screen.payment();
					break;
					
				case 6:							// 티켓 출력하기 
					screen.printTicket();
					break;
				
					
				case 7:							// 메인 메뉴 이동 
					screen = ticketBox.selectScreen();
					break;
					
				default:						// 1 ~ 7이 아닌 다른 번호를 입력했을 경우 실행 
					System.out.println(" 다른 숫자를 입력하였습니다. 정확한 숫자를 입력해주세요. ");
					break;
						
				}
			} catch(InputMismatchException e) {									// 정수가 아닌 것을 입력한 경우 실행 되는 코드 
				System.out.println(" 숫자만 입력해주세요.");						// 다시 입력해달라고 출력 
				continue;														// 프로그램을 종료하지 않고 계속 실행 
			}
		}
	}
}
