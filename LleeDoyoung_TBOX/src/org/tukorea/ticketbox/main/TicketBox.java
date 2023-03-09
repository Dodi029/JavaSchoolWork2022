package org.tukorea.ticketbox.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.tukorea.ticketbox.cinema.DccomicsScreen;
import org.tukorea.ticketbox.cinema.FamillyScreen;
import org.tukorea.ticketbox.cinema.MarvelScreen;
import org.tukorea.ticketbox.cinema.Screen;
import org.tukorea.ticketbox.payment.*;
import org.tukorea.ticketbox.util.*;
import java.util.*;

public class TicketBox {

	private DccomicsScreen dccomicsScreen;
	private FamillyScreen famillyScreen;
	private MarvelScreen marvelScreen;

	Scanner scan = new Scanner(System.in);

	public static final String ADMIN_PASSWORD = "admin";

	public void initScreen() {
		// Screen(영화제목, 영화 줄거리, 티켓가격, 좌석(rowMax), 좌석(colMax))
		famillyScreen = new FamillyScreen("언차티드",
				"평범한 삶을 살던 ‘네이선’(톰 홀랜드)은 인생을 바꿀 뜻밖의 제안을 받는다. 그의 미션은 위험한 트레져 헌터 ‘설리’(마크 월버그)와 함께 사라진 형과 500년 전 잃어버린 천문학적인 가치를 지닌 트레져를 찾아내는 것. 그러나 몬카다(안토니오 반데라스)의 위협과 추격 속, 누구보다 빠르게 미지의 세계에 닿기 위해 결단을 내려야만 하는데…",
				10000, 5, 10);		// 가족 영화관 정보 저장 

		marvelScreen = new MarvelScreen("블랙 팬서 : 와칸다 포에버",
				"국왕이자 ‘블랙 팬서’인 '티찰라'의 죽음 이후 수많은 강대국으로부터 위협을 받게 된 '와칸다'. '라몬다', '슈리' 그리고 '나키아', '오코예, '음바쿠'는 각자 사명감을 갖고 '와칸다'를 지키기 위해 외로운 싸움을 이어간다. 한편, 비브라늄의 패권을 둘러싼 미스터리한 음모와 함께 깊은 해저에서 모습을 드러낸 최강의 적 '네이머'와 '탈로칸'의 전사들은 '와칸다'를 향해 무차별 공격을 퍼붓기 시작하는데…",
				20000, 5,  5) ;		// 마블 영화관 정봏 저장 

		dccomicsScreen = new DccomicsScreen("조커",
				"고담시의 광대 아서 플렉은 코미디언을 꿈꾸는 남자. 하지만 모두가 미쳐가는 코미디 같은 세상에서 맨 정신으로는 그가 설 자리가 없음을 깨닫게 되는데… 이제껏 본 적 없는 진짜 ‘조커’를 만나라!",
				30000, 10, 10);		// DC 영화관 정보 저장 
	}

	public Screen selectScreen() {		// 메인 메뉴 창 
		while (true) {
			System.out.println(" ---------------------");
			System.out.println(" -   상영관 선택 메인메뉴 - ");
			System.out.println(" ---------------------");

			System.out.println(" 1. DC 영화 1관 ");
			System.out.println(" 2. 가족 영화 2관 ");
			System.out.println(" 3. 마블 영화 3관 ");
			
			System.out.println(" ");				// 가독성을 위해 작성 
			System.out.println(" 9. 관리자 메뉴 ");

			System.out.println("    선택(1~3, 9)외 종료 ");

			System.out.println(" ");
			System.out.print(" 상영관 선택 : ");

			try {			// 오류를 잡기 위해 작성 
				int select = scan.nextInt();			// 입력한 정보를 정수형으로 저장 

				switch (select) {				// 입력한 정보에 따라 실행 

				case 1:			// DC 영화관을 선택한 경우 
					return dccomicsScreen;

				case 2:			// 가족 영화관을 선택한 경우 
					return famillyScreen;

				case 3:			// 마블 영화관을 선택한 경우 
					return marvelScreen;

				case 9:			// 관리자 메뉴를 선택한 경우 
					managerMode();
					break;

				default:			// 다른 숫자를 입력한 경우 실행 
					System.out.println(" 다른 번호를 입력했습니다.");
					break;
				}
			} catch (InputMismatchException e) {			// 숫자가 아닌 값을 입력한 경우 
				System.out.println(" 정수만 입력 가능합니다. ");
				continue;
			}
		}
	}

	void managerMode() { // 관리자 기능

		System.out.print(" 관리자 비밀 번호를 입력하세요 : ");
		String pw = scan.next();		// 입력한 정보를 문자열로 저장 

		if (pw.equals(ADMIN_PASSWORD)) {		// 기존에 설정한 비밀 번호와 입력한 정보가 일치할 경우 
			System.out.println(" ---------------------");
			System.out.println(" -     관리자 기능     - ");
			System.out.println(" ---------------------");

			HashMap<Integer, Receipt> dccomicsMap = dccomicsScreen.getReceiptMap();		// HashMap 저장 
			HashMap<Integer, Receipt> famillyMap = famillyScreen.getReceiptMap();
			HashMap<Integer, Receipt> marvelMap = marvelScreen.getReceiptMap();

			System.out.println(" 영화관 총 티켓 판매량 : " + (dccomicsMap.size() + famillyMap.size() + marvelMap.size()));

			System.out.println(" DC 영화관 결제 총액 : " + Statistics.sum(dccomicsMap));		// 총합 출력 
			System.out.println(" 가족 영화관 결제 총액 : " + Statistics.sum(famillyMap));
			System.out.println(" 마블 영화관 결제 총액 : " + Statistics.sum(marvelMap));

			System.out.println(" ");

			ReceiptWriter rw = new ReceiptWriter(); // 영수증 생성자

			System.out.println(" DC 영화관 영수증 전체 출력 ");
			rw.printConsole(dccomicsMap);

			System.out.println(" 가족 영화관 영수증 전체 출력 ");
			rw.printConsole(famillyMap);

			System.out.println(" 마블 영화관 영수증 전체 출략 ");
			rw.printConsole(marvelMap);

			System.out.println(" ");

			System.out.println(" 안녕히 가세요. ");

		}

		else			// 입력한 문자열과 기존에 저장된 비밀 번호가 다를 경우 
			System.out.println(" 잘못된 비밀 번호입니다. ");

	}
}
