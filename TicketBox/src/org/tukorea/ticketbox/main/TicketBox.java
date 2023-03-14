package org.tukorea.ticketbox.main;

import org.tukorea.ticketbox.cinema.*;
import org.tukorea.ticketbox.payment.Receipt;
import org.tukorea.ticketbox.util.*;
import java.util.*;

public class TicketBox {
	private FamilyScreen familyScreen;
	private AnimationScreen animationScreen;
	private PremiumScreen premiumScreen;
	public static final String ADMIN_PASSWORD = "admin";

	Scanner scan = new Scanner(System.in);

	public void initScreen() {
		familyScreen = new FamilyScreen("힘을 내요, 미스터 리",
				"가던 길도 멈추게 하는 심쿵 비주얼의 대복칼국수 반전미남 ‘철수’(차승원) 완벽한 외모와 달리 아이보다\n"
				+ "더 아이 같은 그의 앞에 어느 날 어른보다 더 어른 같은 딸 ‘샛별’(엄채영)이 나타난다. 오늘 처음 봤는데… 내 딸이라고???\n누구냐 넌?! 마른하늘에 '딸'벼락 맞은 철수의 미스터리한 정체가 밝혀진다!",
				12000, 10, 10);
		animationScreen = new AnimationScreen("소울",
				"나는 어떻게 ‘나’로 태어나게 되었을까? \r\n" + "지구에 오기 전 영혼들이 머무는 ‘태어나기 전 세상’이 있다면? ", 20000, 10, 10);
		premiumScreen = new PremiumScreen("테넷",
				"시간의 흐름을 뒤집는 인버전을 통해 현재와 미래를 오가며 세상을 파괴하려는\n사토르(케네스 브래너)를 막기 위해 투입된 작전의 주도자(존 데이비드 워싱턴)."
				+ "\n인버전에 대한 정보를 가진 닐(로버트 패틴슨)과 미술품 감정사이자 사토르에 대한 복수심이 가득한\n그의 아내 캣(엘리자베스 데비키)과 협력해 미래의 공격에 맞서 제3차 세계대전을 막아야 한다!",
				50000, 5, 5);
	}

	public Screen selectScreen() {
		while (true) {
			System.out.println("--------------------");
			System.out.println("- 상영관 선택 메인메뉴 -");
			System.out.println("--------------------");
			System.out.println("1. 가족 영화 1관");
			System.out.println("2. 애니메이션 고화질 영화 2관");
			System.out.println("3. 프리미업 고화질 영화 3관(맥주, 피자 등 음식 제공)");
			System.out.println("9. 관리자 메뉴");
			System.out.println("   선택(1~3)외 종료");
			System.out.println();
			System.out.print("상영관 선택: ");
			try {
				int select = scan.nextInt();
				switch (select) {
				case 1:
					return familyScreen;
				case 2:
					return animationScreen;
				case 3:
					return premiumScreen;
				case 9:
					managerMode();
					break;
				default:
					System.out.println("\n잘못된 수를 입력하셨습니다. 정수(1~3, 9)만 입력가능합니다.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력하지 않았습니다. 정수(1~3, 9)만 입력가능합니다.");
				scan.next();
				continue;
			}
		}

	}

	void managerMode() {
		System.out.print("암호 입력: ");
		String passwd = scan.next();
		if (passwd.equals(ADMIN_PASSWORD)) {
			System.out.println("-------------------");
			System.out.println("---- 관리자 기능 ----");
			System.out.println("-------------------");
			HashMap<Integer, Receipt> familyMap = familyScreen.getReceiptMap();
			HashMap<Integer, Receipt> animationMap = animationScreen.getReceiptMap();
			HashMap<Integer, Receipt> premiumMap = premiumScreen.getReceiptMap();
			System.out.println("영화관 총 티켓 판매량: " + (familyMap.size() + animationMap.size() + premiumMap.size()));
			System.out.println("가족 영화관 결제 총액: " + Statistics.sum(familyMap));
			System.out.println("애니메이션 영화관 결제 총액: " + Statistics.sum(animationMap));
			System.out.println("프리미엄 영화관 결제 총액: " + Statistics.sum(premiumMap));
			System.out.println();
			ReceiptWriter rw = new ReceiptWriter();
			System.out.println("가족 영화관 영수증 전체 출력");
			rw.printConsole(familyMap);
			System.out.println("애니메이션 영화관 영수증 전체 출력");
			rw.printConsole(animationMap);
			System.out.println("프리미엄 영화관 영수증 전체 출력");
			rw.printConsole(premiumMap);
			System.out.println();
			System.out.print("안녕히 가세요!");
			scan.close();
			System.exit(0);
		} else {
			System.out.println("암호가 틀렸습니다.");
		}
	}
}